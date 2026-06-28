package com.ariannavilchez.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariannavilchez.todo.model.ListItem;

// @Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {

}
