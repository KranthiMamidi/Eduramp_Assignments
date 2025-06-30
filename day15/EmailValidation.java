package com.day15;

import java.util.Scanner;

public class EmailValidation {

	public static String emailValidation(String email) {
		if (email.contains("@") && email.endsWith(".com")) {
			return email;
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String email;
		String validatedEmail;

		do {
			System.out.println("Enter your Email:");
			email = s.nextLine();

			email = email.trim();
			email = email.toLowerCase();

			validatedEmail = emailValidation(email);

			if (validatedEmail == null) {
				System.out.println("Invalid email. Please enter a valid email containing '@' and ending with '.com'.");
			}

		} while (validatedEmail == null);

		System.out.println("Valid Email: " + validatedEmail);
		s.close();
	}
}
