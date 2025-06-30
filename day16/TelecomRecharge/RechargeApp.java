package com.day16.TelecomRecharge;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RechargeApp {

	public static void main(String[] args) {
		RechargePlanService service = new RechargePlanService();
		List<RechargePlan> plans = service.getAllPlans();
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== Available Recharge Plans ===");
		plans.forEach(plan -> {
			System.out.println("-----------------------------------");
			System.out.println(plan);
		});

		System.out.print("\nEnter the ID of the plan you want to choose: ");
		int planId = scanner.nextInt();

		Optional<RechargePlan> selectedPlan = service.getPlanById(plans, planId);

		selectedPlan.ifPresentOrElse(plan -> {
			System.out.println("\n You have selected the following plan:");
			System.out.println(plan);
		}, () -> System.out.println("\n Invalid Plan ID."));

		System.out.print("\nDo you want to see plans under ₹500 and at least 28 days validity? (yes/no): ");
		scanner.nextLine();
		String showFiltered = scanner.nextLine();

		if (showFiltered.equalsIgnoreCase("yes")) {
			List<RechargePlan> filtered = service.filterPlansByValidityAndPrice(plans, 28, 500);
			System.out.println("\n Filtered Plans (<= ₹500, Validity >= 28 days):");
			filtered.forEach(System.out::println);
		}

		scanner.close();
	}
}
