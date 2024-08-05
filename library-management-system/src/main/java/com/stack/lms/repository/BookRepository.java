package com.stack.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
