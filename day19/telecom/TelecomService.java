package com.day19.telecom;

public class TelecomService {

	private static TelecomService instance;

	private TelecomService() {
		Logger.getInstance().info("Telecom Service Initialized");
	}

	public static TelecomService getInstance() {
		if (instance == null) {
			instance = new TelecomService();
		}
		return instance;
	}

	public void activatePlan(String phoneNumber, String plan) {
		Logger.getInstance().info("Activating plan for " + phoneNumber + ": " + plan);
	}

	public void sendNotification(String phoneNumber, String message) {
		Logger.getInstance().info("Sending notification to " + phoneNumber + ": " + message);
	}
}
