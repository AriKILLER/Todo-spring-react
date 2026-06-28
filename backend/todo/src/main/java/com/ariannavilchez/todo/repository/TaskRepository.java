package com.ariannavilchez.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariannavilchez.todo.model.Task;
// JPARepository viene con los metodos findAll(), findById(), save(), deleteById(), existsById(), por lo que no hace falta ponerlos explicitamente en el repositorio. Solo se agregan los metodos que no vienen por defecto, como findByUserId(Long id).
// @Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserId(Long id);
}

