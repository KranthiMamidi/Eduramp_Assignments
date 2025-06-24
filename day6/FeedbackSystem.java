package com.day6;

import java.io.*;
import java.util.Scanner;

public class FeedbackSystem {

	static final String FILE_NAME = "feedback.txt";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- Feedback System ---");
			System.out.println("1. Submit Feedback");
			System.out.println("2. View Feedbacks");
			System.out.println("3. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				submitFeedback(scanner);
				break;
			case 2:
				readFeedbacks();
				break;
			case 3:
				System.out.println("Thank you for using the feedback system.");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	// Method to submit feedback (write to file)
	public static void submitFeedback(Scanner scanner) {
		try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // append mode
			System.out.print("Enter your name: ");
			String name = scanner.nextLine();
			System.out.print("Enter your feedback: ");
			String feedback = scanner.nextLine();

			writer.write("Name: " + name + "\n");
			writer.write("Feedback: " + feedback + "\n");
			writer.write("--------\n");
			System.out.println("Feedback submitted successfully.");
		} catch (IOException e) {
			System.out.println("Error writing feedback.");
			e.printStackTrace();
		}
	}

	// Method to read feedbacks from the file
	public static void readFeedbacks() {
		try (FileReader reader = new FileReader(FILE_NAME)) {
			System.out.println("\n--- All Feedbacks ---");
			int ch;
			while ((ch = reader.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No feedback found yet.");
		} catch (IOException e) {
			System.out.println("Error reading feedbacks.");
			e.printStackTrace();
		}
	}
}