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

import com.ariannavilchez.todo.model.ListItem;
import com.ariannavilchez.todo.service.ListItemService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/list-items")
@RequiredArgsConstructor
public class ListItemController {

    private final ListItemService listItemService; 

    @GetMapping
    public List<ListItem> getAllListItems(){
        return listItemService.findAll();
    }

    @PostMapping
    public ListItem addListItem(@RequestBody ListItem listItem){
        return listItemService.save(listItem);
    }

    @PutMapping("/{id}")
    public ListItem updateListItem(@PathVariable Long id, @RequestBody ListItem listItem) {
        return listItemService.update(id, listItem);
    }

    @PutMapping("/{id}/complete")
    public ListItem completeListItem(@PathVariable Long id) {
        return listItemService.completeListItem(id);
    }

    @PutMapping("/{id}/restore")
    public ListItem restoreListItem(@PathVariable Long id) {
        return listItemService.restoreListItem(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteListItem(@PathVariable Long id) {
        listItemService.delete(id);
    }
}
