package bankAssignment;

public class CurrentAccount extends BankAccount implements DocumentVerification {

	private String businessName;

	public CurrentAccount(String accountHolderName, String branch, String panCard, String aadharCard, String address,
			String businessName) {
		super(accountHolderName, branch, panCard, aadharCard, address);
		this.businessName = businessName;
	}

	@Override
	public void verifyDocuments() {
		System.out.println("Verifying PAN, Aadhar, and Business Registration for Current Account...");
		if (panCard.isEmpty() || aadharCard.isEmpty() || businessName.isEmpty()) {
			System.out.println("Document verification failed.");
		} else {
			System.out.println("Documents verified successfully for Current Account.");
		}
	}

	@Override
	public void displayAccountDetails() {
		System.out.println("\n--- Current Account Details ---");
		System.out.println("Account Holder: " + accountHolderName);
		System.out.println("Business Name: " + businessName);
		System.out.println("Branch: " + branch);
		System.out.println("PAN: " + panCard);
		System.out.println("Aadhar: " + aadharCard);
		System.out.println("Address: " + address);

	}

}
