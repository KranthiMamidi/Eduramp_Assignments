package com.day13;

class Student1 {
	String name;
	int marks;

	Student1(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return name + " - " + marks;
	}
}

public class StudentSelectionSort {
	public static void main(String[] args) {
		Student1[] students = { new Student1("Amit", 78), new Student1("Preeti", 92), new Student1("Rahul", 67),
				new Student1("Sneha", 85), new Student1("Zoya", 70) };

		// Selection Sort by marks in descending order
		for (int i = 0; i < students.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[j].marks > students[maxIndex].marks) {
					maxIndex = j;
				}
			}

			// Swap max with current position
			Student1 temp = students[i];
			students[i] = students[maxIndex];
			students[maxIndex] = temp;
		}

		// Display ranked list
		System.out.println("Student Rankings:");
		for (int rank = 0; rank < students.length; rank++) {
			System.out.println((rank + 1) + ". " + students[rank]);
		}
	}
}