package com.day12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class CustomerInfo {
	private String subscriptionPlan;
	private int callCount;
	private double dataUsage;
	private double balance;

	public CustomerInfo(String subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
		this.callCount = 0;
		this.dataUsage = 0.0;
		if ("Prepaid".equals(subscriptionPlan)) {
			this.balance = 100.0;
		}
	}

	public String getSubscriptionPlan() {
		return subscriptionPlan;
	}

	public int getCallCount() {
		return callCount;
	}

	public void makeCall() {
		callCount++;
	}

	public double getDataUsage() {
		return dataUsage;
	}

	public void addDataUsage(double data) {
		this.dataUsage += data;
	}

	public double getBalance() {
		return balance;
	}

	public void deductBalance(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("Insufficient balance.");
		}
	}

	@Override
	public String toString() {
		return "Plan: " + subscriptionPlan + ", Calls: " + callCount + ", Data: " + dataUsage + "GB, Balance: "
				+ balance;
	}
}

public class TelecomServices {
	public static void main(String[] args) {

		Map<String, CustomerInfo> customers = new LinkedHashMap<>();

		customers.put("C101", new CustomerInfo("Prepaid"));
		customers.put("C102", new CustomerInfo("Postpaid"));
		customers.put("C103", new CustomerInfo("Prepaid"));
		customers.put("C104", new CustomerInfo("Postpaid"));

		customers.get("C101").makeCall();
		customers.get("C101").addDataUsage(1.5);
		customers.get("C101").addDataUsage(7);

		customers.get("C101").deductBalance(10.0);

		customers.get("C102").makeCall();
		customers.get("C102").addDataUsage(3.0);

		customers.get("C103").makeCall();
		customers.get("C103").makeCall();
		customers.get("C103").addDataUsage(2.0);

		customers.get("C104").addDataUsage(1.0);

		System.out.println("Customer Information:");
		for (Map.Entry<String, CustomerInfo> entry : customers.entrySet()) {
			System.out.println("Customer ID: " + entry.getKey() + ", " + entry.getValue());
		}
	}
}
