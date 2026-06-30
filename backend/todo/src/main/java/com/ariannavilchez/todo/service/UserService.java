package com.ariannavilchez.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ariannavilchez.todo.model.User;
import com.ariannavilchez.todo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(Long id, User user){
        User existingUser = findById(id);
        if(existingUser != null){
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

}
