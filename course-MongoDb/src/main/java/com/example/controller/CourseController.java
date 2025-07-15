package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Course;
import com.example.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	private final CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	@GetMapping
	public List<Course> getAll() {
		return service.getAllCourses();
	}

	@GetMapping("/{id}")
	public Course getById(@PathVariable String id) {
		return service.getCourseById(id).orElse(null);
	}

	@PostMapping
	public Course create(@RequestBody Course course) {
		return service.addCourse(course);
	}

	@PutMapping("/{id}")
	public Course update(@PathVariable String id, @RequestBody Course course) {
		return service.updateCourse(id, course);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.deleteCourse(id);
	}

}
