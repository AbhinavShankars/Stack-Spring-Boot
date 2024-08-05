package com.stack.spring.app.repository;
/**
 *  Author : Abhinav Shankar
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.spring.app.model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
	List<Program> findByPublished(boolean published);
	List<Program> findByTitleContaining(String title);
}
