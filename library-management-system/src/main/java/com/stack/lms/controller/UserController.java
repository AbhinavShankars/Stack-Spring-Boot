package com.stack.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stack.lms.model.Book;
import com.stack.lms.model.User;
import com.stack.lms.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
    
    @GetMapping("/{id}")
    public User getUserbyID(@PathVariable Long id) {
        return userService.findById(id);
    }
}
