package com.day2;

public class BillingSystem {

	int id;
	String bill_to;
	double amount;
	static String company = "Amazon";
	static double tax = 200;

	public void showBillDetails(int id, String name, double amount) {
		double totalAmount = amount;
		if (amount <= 1000) {
			totalAmount = totalAmount;
		} else if (amount >= 1000 && amount <= 2000) {
			totalAmount -= totalAmount - 50;
		} else if (amount >= 2000 && amount <= 5000) {
			totalAmount -= totalAmount;
		} else if (amount >= 5000 && amount <= 10000) {
			totalAmount -= totalAmount;
		} else {
			totalAmount = amount - 500;
		}
//		System.out.println(id + " " + name + " " + amount + " " + company);
		System.out.println("Bill Id :" + id);
		System.out.println("Bill to :" + name);
		System.out.println("amount :" + totalAmount);
		System.out.println("Biller : " + company);
	}

	public static void companyName() {
		System.out.println(company);
	}

	public static void main(String[] args) {
		BillingSystem.companyName();
		BillingSystem bs = new BillingSystem();
//		bs.biller_name = "Kranthi";
//		bs.id = 1;
		bs.showBillDetails(1, "Kranthi", 10000);
		bs.showBillDetails(2, "Anand", 1000);
		bs.showBillDetails(3, "Ramesh", 11000);

	}
}
