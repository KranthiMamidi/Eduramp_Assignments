package com.day7;

public class Payment {

	public boolean processPayment(String user, double amount) {
		// Simulate payment processing (Here it's always successful for simplicity)
		System.out.println(user + " paid " + amount + " for the purchase.");
		return true; // In a real-world application, this could interact with a payment gateway.
	}

}
