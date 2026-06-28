package com.ariannavilchez.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariannavilchez.todo.model.User;


// @Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
