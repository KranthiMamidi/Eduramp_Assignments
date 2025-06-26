package com.day13;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return name + " - " + marks;
	}
}

public class StudentBubbleSort {
	public static void main(String[] args) {
		Student[] students = { new Student("Amit", 78), new Student("Preeti", 92), new Student("Rahul", 67),
				new Student("Sneha", 85), new Student("Zoya", 70) };

		// Bubble Sort by marks in descending order
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length - 1; j++) {
				if (students[j].marks < students[j + 1].marks) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}

		// Display ranked list
		System.out.println("Student Rankings:");
		for (int rank = 0; rank < students.length; rank++) {
			System.out.println((rank + 1) + ". " + students[rank]);
		}
	}
}