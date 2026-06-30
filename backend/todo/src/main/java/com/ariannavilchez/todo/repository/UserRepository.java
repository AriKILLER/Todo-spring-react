package com.ariannavilchez.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariannavilchez.todo.model.User;

// JPARepository viene con los metodos findAll(), findById(), save(), deleteById(), existsById(), por lo que no hace falta ponerlos explicitamente en el repositorio. Solo se agregan los metodos que no vienen por defecto, como findByUserId(Long id).
// @Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
