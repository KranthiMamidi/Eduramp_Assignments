package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository repository;

	public CourseService(CourseRepository repository) {
		this.repository = repository;
	}

	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	public Optional<Course> getCourseById(String id) {
		return repository.findById(id);
	}

	public Course addCourse(Course course) {
		return repository.save(course);
	}

	public Course updateCourse(String id, Course course) {
		course.setId(id);
		return repository.save(course);
	}

	public void deleteCourse(String id) {
		repository.deleteById(id);
	}
}
