package com.jcpv.example.questionmarks.controller;

import com.jcpv.example.questionmarks.model.User;
import com.jcpv.example.questionmarks.repository.UserRepository;
import com.jcpv.example.questionmarks.util.exeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jancarlo on 23/03/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user/{name}")
    public List<User> findByName(@PathVariable String name){
        return userRepository.findByName(name);

    }
    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
