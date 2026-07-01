package com.ariannavilchez.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariannavilchez.todo.model.ListItem;
// JPARepository viene con los metodos findAll(), findById(), save(), deleteById(), existsById(), por lo que no hace falta ponerlos explicitamente en el repositorio. Solo se agregan los metodos que no vienen por defecto, como findByUserId(Long id).
// @Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    List<ListItem> findByTaskId(Long taskId);
}
