package com.ariannavilchez.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariannavilchez.todo.model.Task;
import com.ariannavilchez.todo.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping()
    public Task createTask(@RequestBody Task task){
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task){
        return taskService.update(id, task);
    }

    @PutMapping("/{id}/complete")
    public Task completedTask(@PathVariable Long id){
        return taskService.completeTask(id);
    }

    @PutMapping("/{id}/restore")
    public Task restoredTask(@PathVariable Long id){
        return taskService.restoreTask(id);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return null;
    }
}
