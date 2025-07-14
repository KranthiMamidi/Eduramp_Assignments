package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository repository;

	public List<ToDo> getAll() {
		return repository.findAll();
	}

	public ToDo getById(int id) {
		return repository.findById(id).orElse(null);
	}

	public ToDo add(ToDo todo) {
		return repository.save(todo);
	}

	public ToDo update(int id, ToDo updatedTodo) {
		Optional<ToDo> existing = repository.findById(id);
		if (existing.isPresent()) {
			ToDo todo = existing.get();
			todo.setTitle(updatedTodo.getTitle());
			todo.setCompleted(updatedTodo.isCompleted());
			return repository.save(todo);
		}
		return null;
	}

	public void delete(int id) {
		repository.deleteById(id);
	}
}
