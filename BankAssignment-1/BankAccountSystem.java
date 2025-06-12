package bankAssignment;

import java.util.Scanner;

public class BankAccountSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to HDFC Bank Account Opening Portal!");
		System.out.print("Enter Account Type (Savings/Current): ");
		String accType = sc.nextLine();

		System.out.print("Enter Full Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Branch Name: ");
		String branch = sc.nextLine();
		System.out.print("Enter PAN Card Number: ");
		String pan = sc.nextLine();
		System.out.print("Enter Aadhar Card Number: ");
		String aadhar = sc.nextLine();
		System.out.print("Enter Address: ");
		String address = sc.nextLine();

		BankAccount account = null;

		if (accType.equalsIgnoreCase("Savings")) {
			account = new SavingsAccount(name, branch, pan, aadhar, address);
		} else if (accType.equalsIgnoreCase("Current")) {
			System.out.print("Enter Business Name: ");
			String businessName = sc.nextLine();
			account = new CurrentAccount(name, branch, pan, aadhar, address, businessName);
		} else {
			System.out.println("Invalid account type selected.");
			sc.close();
			return;
		}

		DocumentVerification verifier = (DocumentVerification) account;
		verifier.verifyDocuments();

		account.displayAccountDetails();

		sc.close();
	}
}
