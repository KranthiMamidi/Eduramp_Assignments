package com.day9.linkedListtt;

public class Order {

	private int orderId;
	private String productName;
	private double amount;

	public Order(int orderId, String productName, double amount) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", amount=" + amount + "]";
	}

}
