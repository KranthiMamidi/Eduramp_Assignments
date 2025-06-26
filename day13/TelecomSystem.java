package com.day13;

import java.util.Vector;

class UsageRecordd {

	String type;

	String detail;

	public UsageRecordd(String type, String detail) {

		this.type = type;

		this.detail = detail;

	}

	@Override

	public String toString() {

		return type + ": " + detail;

	}

}

class UsageLogger {

	private Vector<UsageRecordd> usageRecords = new Vector<>();

	public void logUsage(String type, String detail) {

		usageRecords.add(new UsageRecordd(type, detail));

	}

	public void printUsage() {

		for (UsageRecordd record : usageRecords) {

			System.out.println(record);

		}

	}

}

public class TelecomSystem {

	public static void main(String[] args) {

		UsageLogger logger = new UsageLogger();

		// Simulating multiple threads

		Thread callLogger = new Thread(() -> logger.logUsage("Call", "Duration: 5 mins"));

		Thread smsLogger = new Thread(() -> logger.logUsage("SMS", "To: +9188766568"));

		Thread dataLogger = new Thread(() -> logger.logUsage("Data", "Used: 200MB"));

		callLogger.start();

		smsLogger.start();

		dataLogger.start();

		// System.out.println();

		try {

			callLogger.join();

			smsLogger.join();

			dataLogger.join();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.out.println("Usage Logs:");

		logger.printUsage();

	}

}
