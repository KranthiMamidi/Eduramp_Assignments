package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Course;

public interface CourseRepository extends MongoRepository<Course, String> {

}