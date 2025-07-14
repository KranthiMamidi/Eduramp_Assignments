package com.example.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	@Autowired
	private ToDoService service;

	@GetMapping
	public List<ToDo> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ToDo getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping
	public ToDo add(@RequestBody ToDo todo) {
		return service.add(todo);
	}

	@PutMapping("/{id}")
	public ToDo update(@PathVariable int id, @RequestBody ToDo todo) {
		return service.update(id, todo);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
