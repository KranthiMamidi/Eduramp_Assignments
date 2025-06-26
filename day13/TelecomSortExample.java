package com.day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TelecomPlan {

	String planName;
	double price;
	int dataLimit;
	int validity;
	
	public TelecomPlan(String planName, double price, int dataLimit, int validity) {
		this.planName = planName;
		this.price = price;
		this.dataLimit = dataLimit;
		this.validity = validity;
	}

	public String getPlanName() {
		return planName;
	}

	public double getPrice() {
		return price;
	}

	public int getDataLimit() {
		return dataLimit;
	}

	public int getValidity() {
		return validity;
	}

	@Override
	public String toString() {
		return "TelecomPlan [planName=" + planName + ", price=" + price + ", dataLimit=" + dataLimit + "GB, validity="
				+ validity + " days]";
	}
}

public class TelecomSortExample {

	public static void main(String[] args) {

		List<TelecomPlan> plans = new ArrayList<>();

		plans.add(new TelecomPlan("Basic", 199.0, 1, 28));
		plans.add(new TelecomPlan("Standard", 299.0, 2, 28));
		plans.add(new TelecomPlan("Premium", 499.0, 3, 56));
		plans.add(new TelecomPlan("Unlimited", 799.0, 5, 84));

		System.out.println("Original Plans:");
		for (TelecomPlan p : plans) {
			System.out.println(p);
		}

		// sort_price.sort(Comparator.comparingDouble(p -> p.price));
		plans.sort(Comparator.comparingDouble(TelecomPlan::getPrice));

		System.out.println("Sorted by Price (Low to High):");
		for (TelecomPlan p : plans) {
			System.out.println(p);
		}

		plans.sort(Comparator.comparingInt(TelecomPlan::getDataLimit));

		System.out.println("Sorted by Data Limit (Low to High):");
		for (TelecomPlan p : plans) {
			System.out.println(p);
		}

		plans.sort(Comparator.comparingInt(TelecomPlan::getValidity));

		System.out.println("Sorted by Validity (Low to High):");
		for (TelecomPlan p : plans) {
			System.out.println(p);
		}
	}
}
