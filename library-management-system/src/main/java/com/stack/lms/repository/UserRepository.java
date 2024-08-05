package com.stack.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.lms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
