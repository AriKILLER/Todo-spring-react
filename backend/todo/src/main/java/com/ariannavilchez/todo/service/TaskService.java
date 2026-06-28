package com.ariannavilchez.todo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ariannavilchez.todo.model.Task;
import com.ariannavilchez.todo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    
    public Task findById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task save(Task task){
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task update(Long id,Task task){
        Task existingTask = findById(id);
        if (existingTask != null) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task completeTask(Long id){
        Task existingTask = findById(id);
        if (existingTask != null) {
            existingTask.setCompleted(true);
            existingTask.setCompletedAt(LocalDateTime.now());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public Task restoreTask(Long id){
        Task existingTask = findById(id);
        if(existingTask != null){
            existingTask.setCompleted(false);
            existingTask.setCompletedAt(null);
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

}
