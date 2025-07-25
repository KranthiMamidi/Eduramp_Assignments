package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}
