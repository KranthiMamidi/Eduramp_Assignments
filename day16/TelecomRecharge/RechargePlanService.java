package com.day16.TelecomRecharge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RechargePlanService {

	public List<RechargePlan> getAllPlans() {
		return Arrays.asList(new RechargePlan(1, "Basic", 99.0, 14, 1.0, 100, true, false),
				new RechargePlan(2, "Value", 199.0, 28, 1.5, 100, true, false),
				new RechargePlan(3, "Premium", 399.0, 56, 2.0, 100, true, false),
				new RechargePlan(4, "Super Saver", 599.0, 84, 2.5, 100, true, true),
				new RechargePlan(5, "Annual", 2399.0, 365, 2.5, 100, true, true));
	}

	public List<RechargePlan> filterPlansByValidityAndPrice(List<RechargePlan> plans, int minValidity,
			double maxPrice) {
		return plans.stream().filter(p -> p.getValidity() >= minValidity && p.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}

	// Sort plans by price (ascending)
	public List<RechargePlan> sortByPrice(List<RechargePlan> plans) {
		return plans.stream().sorted(Comparator.comparingDouble(RechargePlan::getPrice)).collect(Collectors.toList());
	}

	// Get plan by ID using Optional
	public Optional<RechargePlan> getPlanById(List<RechargePlan> plans, int id) {
		return plans.stream().filter(p -> p.getId() == id).findFirst();
	}

}
