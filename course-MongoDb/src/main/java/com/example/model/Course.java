package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "courses")
public class Course {

	@Id
	private String id;
	private String name;
	private String trainer;
	private int durationInHours;

	public Course() {
	}

	public Course(String id, String name, String trainer, int durationInHours) {
		this.id = id;
		this.name = name;
		this.trainer = trainer;
		this.durationInHours = durationInHours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

}
