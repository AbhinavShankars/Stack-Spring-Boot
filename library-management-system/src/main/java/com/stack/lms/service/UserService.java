package com.stack.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.lms.model.Book;
import com.stack.lms.model.User;
import com.stack.lms.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    
    
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
