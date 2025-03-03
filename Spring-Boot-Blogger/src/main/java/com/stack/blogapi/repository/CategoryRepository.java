package com.stack.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stack.blogapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
