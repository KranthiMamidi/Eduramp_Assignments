package bankAssignment2;

import java.util.Scanner;
import java.util.UUID;

// Abstract Class for Bank Account
abstract class BankAccount {
	private final String accountNumber;
	protected String accountHolderName;
	protected String mobileNumber;
	protected double balance;

	public BankAccount(String accountHolderName, String mobileNumber, double initialDeposit) {
		this.accountNumber = generateAccountNumber();
		this.accountHolderName = accountHolderName;
		this.mobileNumber = mobileNumber;
		this.balance = initialDeposit;
	}

	private String generateAccountNumber() {
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public abstract boolean openAccount();

	public abstract void withdraw(double amount);

	public abstract double calculateInterest();

	public void displayAccountDetails() {
		System.out.println("Account Number   : " + accountNumber);
		System.out.println("Account Holder   : " + accountHolderName);
		System.out.println("Mobile Number    : " + mobileNumber);
		System.out.println("Balance          : Rs." + balance);
	}
}

// Saving Account
class SavingAccount extends BankAccount {
	private static final double MIN_DEPOSIT = 1000;
	private static final double INTEREST_RATE = 0.04;
	private int withdrawalCount = 0;
	private static final int MAX_WITHDRAWALS = 3;

	public SavingAccount(String name, String mobile, double deposit) {
		super(name, mobile, deposit);
	}

	@Override
	public boolean openAccount() {
		if (balance < MIN_DEPOSIT) {
			System.out.println("Minimum deposit for Saving Account is Rs.1000.");
			return false;
		}
		System.out.println("Savings Account opened successfully.");
		return true;
	}

	@Override
	public void withdraw(double amount) {
		if (withdrawalCount >= MAX_WITHDRAWALS) {
			System.out.println("Withdrawal limit reached (3/month).");
			return;
		}
		if (amount <= balance) {
			balance -= amount;
			withdrawalCount++;
			System.out.println("Withdrawal successful. Remaining Balance: Rs." + balance);
		} else {
			System.out.println("Insufficient balance.");
		}
	}

	@Override
	public double calculateInterest() {
		return balance * INTEREST_RATE;
	}
}

// Current Account
class CurrentAccount extends BankAccount {
	private static final double MIN_DEPOSIT = 5000;
	private static final double MIN_BALANCE = 2000;
	private static final double PENALTY = 500;
	private String businessName;

	public CurrentAccount(String name, String mobile, double deposit, String businessName) {
		super(name, mobile, deposit);
		this.businessName = businessName;
	}

	@Override
	public boolean openAccount() {
		if (balance < MIN_DEPOSIT) {
			System.out.println("Minimum deposit for Current Account is Rs.5000.");
			return false;
		}
		System.out.println("Current Account opened successfully.");
		return true;
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful. Remaining Balance: Rs." + balance);
			if (balance < MIN_BALANCE) {
				balance -= PENALTY;
				System.out.println("Balance below minimum. Rs.500 penalty applied.");
			}
		} else {
			System.out.println("Insufficient balance.");
		}
	}

	@Override
	public double calculateInterest() {
		return 0.0;
	}

	@Override
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println("Business Name     : " + (businessName.isEmpty() ? "N/A" : businessName));
	}
}

// Main Class
public class BankSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount account = null;

		System.out.println("Welcome to SBI Bank - Account Opening System");
		System.out.print("Enter account type (Saving/Current): ");
		String type = sc.nextLine().trim();

		System.out.print("Enter full name: ");
		String name = sc.nextLine();

		System.out.print("Enter mobile number: ");
		String mobile = sc.nextLine();

		System.out.print("Enter initial deposit: Rs.");
		double deposit = sc.nextDouble();
		sc.nextLine();

		if (type.equalsIgnoreCase("Saving")) {
			account = new SavingAccount(name, mobile, deposit);
		} else if (type.equalsIgnoreCase("Current")) {
			System.out.print("Enter business name : ");
			String businessName = sc.nextLine();
			account = new CurrentAccount(name, mobile, deposit, businessName);
		} else {
			System.out.println("Invalid account type.");
			sc.close();
			return;
		}

		if (!account.openAccount()) {
			System.out.println("Account opening failed due to validation.");
			sc.close();
			return;
		}

		account.displayAccountDetails();

		System.out.println("\nCalculating interest (if any): Rs." + account.calculateInterest());

		System.out.print("\nWould you like to make a withdrawal? (yes/no): ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("yes")) {
			System.out.print("Enter amount to withdraw: Rs.");
			double amount = sc.nextDouble();
			account.withdraw(amount);
		}

		System.out.println("\nFinal Account Summary:");
		account.displayAccountDetails();

		sc.close();
	}
}
