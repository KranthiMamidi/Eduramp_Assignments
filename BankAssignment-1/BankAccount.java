package bankAssignment;

public abstract class BankAccount {

	protected String accountHolderName;
	protected String branch;
	protected String panCard;
	protected String aadharCard;
	protected String address;

	public BankAccount(String accountHolderName, String branch, String panCard, String aadharCard, String address) {
		this.accountHolderName = accountHolderName;
		this.branch = branch;
		this.panCard = panCard;
		this.aadharCard = aadharCard;
		this.address = address;
	}

	public abstract void displayAccountDetails();

}
