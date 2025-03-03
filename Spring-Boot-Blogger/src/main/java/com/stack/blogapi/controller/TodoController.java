package com.stack.blogapi.controller;

import com.stack.blogapi.model.Todo;
import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.PagedResponse;
import com.stack.blogapi.security.CurrentUser;
import com.stack.blogapi.security.UserPrincipal;
import com.stack.blogapi.utils.AppConstants;
import com.stacke.blogapi.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<PagedResponse<Todo>> getAllTodos(
			@CurrentUser UserPrincipal currentUser,
			@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<Todo> response = todoService.getAllTodos(currentUser, page, size);

		return new ResponseEntity< >(response, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo, @CurrentUser UserPrincipal currentUser) {
		Todo newTodo = todoService.addTodo(todo, currentUser);

		return new ResponseEntity< >(newTodo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Todo> getTodo(@PathVariable(value = "id") Long id, @CurrentUser UserPrincipal currentUser) {
		Todo todo = todoService.getTodo(id, currentUser);

		return new ResponseEntity< >(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") Long id, @Valid @RequestBody Todo newTodo,
			@CurrentUser UserPrincipal currentUser) {
		Todo updatedTodo = todoService.updateTodo(id, newTodo, currentUser);

		return new ResponseEntity< >(updatedTodo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ApiResponse> deleteTodo(@PathVariable(value = "id") Long id, @CurrentUser UserPrincipal currentUser) {
		ApiResponse apiResponse = todoService.deleteTodo(id, currentUser);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/{id}/complete")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Todo> completeTodo(@PathVariable(value = "id") Long id, @CurrentUser UserPrincipal currentUser) {

		Todo todo = todoService.completeTodo(id, currentUser);

		return new ResponseEntity< >(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}/unComplete")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Todo> unCompleteTodo(@PathVariable(value = "id") Long id, @CurrentUser UserPrincipal currentUser) {

		Todo todo = todoService.unCompleteTodo(id, currentUser);

		return new ResponseEntity< >(todo, HttpStatus.OK);
	}
}
