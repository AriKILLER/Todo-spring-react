package com.ariannavilchez.todo.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/list-items")
public class ListItemController {

    @GetMapping("")
    public String getAllListItems(){
        return "Lista de elementos de la lista";
    }

    @PostMapping()
    public String addListItem(){
        return "Elemento de lista agregado";
    }

    @PutMapping("/{id}")
    public String updateListItem(@PathVariable String id) {
        return "Elemento de lista con ID: " + id + " actualizado";
    }

    @PutMapping("/{id}/complete")
    public String completeListItem(@PathVariable String id) {
        return "Elemento de lista con ID: " + id + " marcado como completado";
    }

    @PutMapping("/{id}/restore")
    public String restoreListItem(@PathVariable String id) {
        return "Elemento de lista con ID: " + id + " restaurado";
    }
    
    @DeleteMapping("/{id}")
    public String deleteListItem(@PathVariable String id) {
        return "Elemento de lista con ID: " + id + " eliminado";
    }
}
