package com.day19.telecom;

public class TelecomTest {
	public static void main(String[] args) {

		TelecomService service = TelecomService.getInstance();

		service.activatePlan("9876543210", "199 - 28 Days - 1.5GB/day");
		service.sendNotification("9876543210", "Plan activated successfully");

		Logger logger = Logger.getInstance();
		logger.error("Invalid recharge amount entered");
	}
}
