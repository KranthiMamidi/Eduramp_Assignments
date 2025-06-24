package tcmsAssignment;

import java.util.*;

public class TelecomManagementSystem {
	private final Map<String, Customer> customers = new HashMap<>();

	public boolean addCustomer(String customerId, String name) {
		if (customers.containsKey(customerId)) {
			System.out.println("Customer with ID " + customerId + " already exists.");
			return false;
		}
		customers.put(customerId, new Customer(customerId, name));
		System.out.println("Customer added: " + name);
		return true;
	}

	public boolean recordCall(String customerId, String calledNumber, int durationSeconds) {
		Customer c = customers.get(customerId);
		if (c == null) {
			System.out.println("Customer not found: " + customerId);
			return false;
		}
		c.addCall(calledNumber, durationSeconds);
		System.out.println("Call recorded for customer " + customerId);
		return true;
	}

	public boolean subscribeVAS(String customerId, String vasName) {
		Customer c = customers.get(customerId);
		if (c == null) {
			System.out.println("Customer not found: " + customerId);
			return false;
		}
		if (c.subscribeVAS(vasName)) {
			System.out.println("Subscribed " + vasName + " for customer " + customerId);
			return true;
		} else {
			System.out.println("Customer already subscribed to " + vasName);
			return false;
		}
	}

	public boolean unsubscribeVAS(String customerId, String vasName) {
		Customer c = customers.get(customerId);
		if (c == null) {
			System.out.println("Customer not found: " + customerId);
			return false;
		}
		if (c.unsubscribeVAS(vasName)) {
			System.out.println("Unsubscribed " + vasName + " for customer " + customerId);
			return true;
		} else {
			System.out.println("Customer was not subscribed to " + vasName);
			return false;
		}
	}

	public boolean fileComplaint(String customerId, String description) {
		Customer c = customers.get(customerId);
		if (c == null) {
			System.out.println("Customer not found: " + customerId);
			return false;
		}
		c.fileComplaint(description);
		System.out.println("Complaint filed for customer " + customerId);
		return true;
	}

	public boolean viewComplaints(String customerId) {
		Customer c = customers.get(customerId);
		if (c == null) {
			System.out.println("Customer not found: " + customerId);
			return false;
		}
		List<Complaint> complaints = c.getComplaints();
		if (complaints.isEmpty()) {
			System.out.println("No complaints filed for customer " + customerId);
		} else {
			System.out.println("Complaints for customer " + customerId + ":");
			for (Complaint comp : complaints) {
				System.out.println("  " + comp);
			}
		}
		return true;
	}

	public void displayAllCustomers() {
		if (customers.isEmpty()) {
			System.out.println("No customers in the system.");
			return;
		}
		System.out.println("\n---- All Customers Summary ----");
		for (Customer c : customers.values()) {
			c.displaySummary();
		}
	}
}
