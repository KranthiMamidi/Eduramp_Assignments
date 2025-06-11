package bankAssignment;

public class SavingsAccount extends BankAccount implements DocumentVerification {

	private double minimumBalance;

	public SavingsAccount(String name, String branch, String pan, String aadhar, String address) {
		super(name, branch, pan, aadhar, address);
		this.minimumBalance = 1000; 
	}

	@Override
	public void verifyDocuments() {
		System.out.println("Verifying PAN Card and Aadhar Card for Savings Account...");
		if (panCard.isEmpty() || aadharCard.isEmpty()) {
			System.out.println("Document verification failed: PAN or Aadhar missing.");
		} else {
			System.out.println("Documents verified successfully for Savings Account.");
		}
	}

	@Override
	public void displayAccountDetails() {
		System.out.println("\n--- Savings Account Details ---");
		System.out.println("Account Holder: " + accountHolderName);
		System.out.println("Branch: " + branch);
		System.out.println("PAN: " + panCard);
		System.out.println("Aadhar: " + aadharCard);
		System.out.println("Address: " + address);
		System.out.println("Minimum Balance: ₹" + minimumBalance);
	}

}
