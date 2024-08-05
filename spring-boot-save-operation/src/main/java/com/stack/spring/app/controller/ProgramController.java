package com.stack.spring.app.controller;
/**
 *  Author : Abhinav Shankar
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stack.spring.app.model.Program;
import com.stack.spring.app.repository.ProgramRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProgramController {

	@Autowired
	ProgramRepository programRepository;

	@GetMapping("/tutorials")
	public ResponseEntity<List<Program>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Program> programs = new ArrayList<Program>();

			if (title == null)
				programRepository.findAll().forEach(programs::add);
			else
				programRepository.findByTitleContaining(title).forEach(programs::add);

			if (programs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(programs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Program> getTutorialById(@PathVariable("id") long id) {
		Optional<Program> tutorialData = programRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tutorials")
	public ResponseEntity<Program> createTutorial(@RequestBody Program program) {
		try {
			Program _tutorial = programRepository
					.save(new Program(program.getTitle(), program.getDescription(), false));
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Program> updateTutorial(@PathVariable("id") long id, @RequestBody Program program) {
		Optional<Program> tutorialData = programRepository.findById(id);

		if (tutorialData.isPresent()) {
			Program _tutorial = tutorialData.get();
			_tutorial.setTitle(program.getTitle());
			_tutorial.setDescription(program.getDescription());
			_tutorial.setPublished(program.isPublished());
			return new ResponseEntity<>(programRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			programRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			programRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Program>> findByPublished() {
		try {
			List<Program> programs = programRepository.findByPublished(true);

			if (programs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(programs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
