package com.ariannavilchez.todo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "list_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListItem {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean completed=false;

    @JsonIgnore // evita el bucle infinito al pedir las tareas con sus elementos de lista
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
