package com.day13;

import java.util.*;

// ---------------- Base UsageRecord ----------------
abstract class UsageRecord {
	protected Date timestamp;

	public UsageRecord() {
		this.timestamp = new Date();
	}

	public abstract String getType();

	public abstract String getDetails();

	@Override
	public String toString() {
		return "[" + getType() + "] " + getDetails() + " @ " + timestamp;
	}
}

// ---------------- Subtypes ----------------
class CallRecord extends UsageRecord {
	private String toNumber;
	private int duration;

	public CallRecord(String toNumber, int duration) {
		this.toNumber = toNumber;
		this.duration = duration;
	}

	public String getType() {
		return "Call";
	}

	public String getDetails() {
		return "To: " + toNumber + ", Duration: " + duration + " min";
	}
}

class SmsRecord extends UsageRecord {
	private String toNumber;
	private String message;

	public SmsRecord(String toNumber, String message) {
		this.toNumber = toNumber;
		this.message = message;
	}

	public String getType() {
		return "SMS";
	}

	public String getDetails() {
		return "To: " + toNumber + ", Msg: " + message;
	}
}

class DataUsageRecord extends UsageRecord {
	private double mbUsed;

	public DataUsageRecord(double mbUsed) {
		this.mbUsed = mbUsed;
	}

	public String getType() {
		return "Data";
	}

	public String getDetails() {
		return "Used: " + mbUsed + " MB";
	}
}

// ---------------- Customer ----------------
class Customer {
	private String name;
	private String number;
	private Vector<UsageRecord> usageRecords;

	public Customer(String name, String number) {
		this.name = name;
		this.number = number;
		this.usageRecords = new Vector<>();
	}

	public void addUsage(UsageRecord record) {
		usageRecords.add(record);
		System.out.println("[" + name + "] " + record);
	}

	public void showUsage() {
		System.out.println("\n=== Usage Report for " + name + " ===");
		for (UsageRecord record : usageRecords) {
			System.out.println(record);
		}
	}
}

// ---------------- Worker Threads ----------------
class CallLogger implements Runnable {
	private Customer customer;

	public CallLogger(Customer customer) {
		this.customer = customer;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			customer.addUsage(new CallRecord("98765" + i, (1 + i % 3)));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class SmsLogger implements Runnable {
	private Customer customer;

	public SmsLogger(Customer customer) {
		this.customer = customer;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			customer.addUsage(new SmsRecord("88888" + i, "Hello " + i));
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
			}
		}
	}
}

class DataLogger implements Runnable {
	private Customer customer;

	public DataLogger(Customer customer) {
		this.customer = customer;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			customer.addUsage(new DataUsageRecord((Math.random() * 10)));
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
			}
		}
	}
}

// ---------------- Main System ----------------
public class TelecomSystemVector {
	public static void main(String[] args) {
		Customer john = new Customer("John", "999001");

		Thread callThread = new Thread(new CallLogger(john));
		Thread smsThread = new Thread(new SmsLogger(john));
		Thread dataThread = new Thread(new DataLogger(john));

		// Start all threads
		callThread.start();
		smsThread.start();
		dataThread.start();

		// Wait for all to finish
		try {
			callThread.join();
			smsThread.join();
			dataThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Show final usage
		john.showUsage();
	}
}
