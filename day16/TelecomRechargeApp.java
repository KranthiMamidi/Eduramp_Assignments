package com.day16;

import java.util.*;
import java.util.stream.*;

class RechargePlan {
	private int id;
	private String name;
	private double price;
	private int validity; // in days
	private String benefits;

	public RechargePlan(int id, String name, double price, int validity, String benefits) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.validity = validity;
		this.benefits = benefits;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return String.format("ID: %d | Plan: %s | ₹%.2f | Validity: %d days | Benefits: %s", id, name, price, validity,
				benefits);
	}
}

public class TelecomRechargeApp {

	// Define available plans
	private static List<RechargePlan> getAvailablePlans() {
		return Arrays.asList(new RechargePlan(1, "Basic Plan", 99, 14, "1GB/day, 100 SMS/day"),
				new RechargePlan(2, "Value Plan", 199, 28, "1.5GB/day, 100 SMS/day, Unlimited Calls"),
				new RechargePlan(3, "Premium Plan", 399, 56, "2GB/day, 100 SMS/day, Unlimited Calls"),
				new RechargePlan(4, "Annual Plan", 2399, 365, "2.5GB/day, 100 SMS/day, Unlimited Calls + OTT"));
	}

	// Choose a plan by ID using Java 8 features
	public static Optional<RechargePlan> choosePlanById(int id, List<RechargePlan> plans) {
		return plans.stream().filter(plan -> plan.getId() == id).findFirst();
	}

	public static void main(String[] args) {
		List<RechargePlan> plans = getAvailablePlans();

		System.out.println("Available Recharge Plans:");
		plans.forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the ID of the plan you want to choose: ");
		int selectedId = scanner.nextInt();

		Optional<RechargePlan> selectedPlan = choosePlanById(selectedId, plans);

		selectedPlan.ifPresentOrElse(plan -> System.out.println("\nYou have selected:\n" + plan),
				() -> System.out.println("\nInvalid plan ID. Please try again."));

		scanner.close();
	}
}
