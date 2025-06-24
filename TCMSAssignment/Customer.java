package tcmsAssignment;

import java.util.*;

public class Customer {
	private final String customerId;
	private final String name;

	private final List<Call> callHistory = new ArrayList<>();
	private final Set<String> subscribedVAS = new HashSet<>();
	private final List<Complaint> complaints = new ArrayList<>();

	public Customer(String customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}

	public void addCall(String calledNumber, int durationSeconds) {
		callHistory.add(new Call(calledNumber, durationSeconds));
	}

	public boolean subscribeVAS(String vasName) {
		return subscribedVAS.add(vasName);
	}

	public boolean unsubscribeVAS(String vasName) {
		return subscribedVAS.remove(vasName);
	}

	public void fileComplaint(String description) {
		complaints.add(new Complaint(description));
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public List<Call> getCallHistory() {
		return Collections.unmodifiableList(callHistory);
	}

	public Set<String> getSubscribedVAS() {
		return Collections.unmodifiableSet(subscribedVAS);
	}

	public List<Complaint> getComplaints() {
		return Collections.unmodifiableList(complaints);
	}

	public void displaySummary() {
		System.out.println("Customer ID: " + customerId + ", Name: " + name);
		System.out.println("Subscribed VAS: " + (subscribedVAS.isEmpty() ? "None" : subscribedVAS));
		System.out.println("Call History:");
		if (callHistory.isEmpty()) {
			System.out.println("  No calls made.");
		} else {
			for (Call c : callHistory) {
				System.out.println("  " + c);
			}
		}
		System.out.println("Complaints:");
		if (complaints.isEmpty()) {
			System.out.println("  No complaints filed.");
		} else {
			for (Complaint comp : complaints) {
				System.out.println("  " + comp);
			}
		}
		System.out.println("------------------------------------------------");
	}
}
