package com.day2;

import java.util.Scanner;

public class ATMWithdrawal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double balance = 2000.0;

		System.out.println("Welcome to InfoVision Bank ATM");

		System.out.println("Do you want to make transaction? (yes/no):");

		String choice = scan.nextLine();

		while (choice.equalsIgnoreCase("yes")) {

			System.out.println("Enter the amount to withdraw");

			double amount = scan.nextDouble();

			scan.nextLine();

			if (amount > 0 && amount <= balance) {
				balance -= amount;
				System.out.println("Transaction successful " + balance);
			} else {
				System.out.println("Invalid amount. Transaction failed!");
			}
			System.out.println("Do you want to make transaction? (yes/no):");
			choice = scan.nextLine();
		}
		System.out.println("Thank you!");
		scan.close();
	}

}
