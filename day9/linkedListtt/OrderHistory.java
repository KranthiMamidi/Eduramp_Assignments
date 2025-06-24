package com.day9.linkedListtt;

import java.util.LinkedList;

public class OrderHistory {

	private LinkedList<Order> orders;

	public OrderHistory() {
		orders = new LinkedList<>();
	}

	public void addOrder(Order order) {
		orders.addLast(order);
		System.out.println("Added: " + order);
	}

	public void removeOldestOrder() {
		if (!orders.isEmpty()) {
			Order removed = orders.removeFirst();
			System.out.println("Removed oldest order: " + removed);
		} else {
			System.out.println("No orders to remove.");
		}
	}

	public void displayOrders() {
		if (orders.isEmpty()) {
			System.out.println("Order history is empty.");
			return;
		}
		System.out.println("Order History:");
		for (Order order : orders) {
			System.out.println(order);
		}
	}

	public void setOrder(int index, Order newOrder) {
		if (index < 0 || index >= orders.size()) {
			System.out.println("Invalid index: " + index);
			return;
		}
		Order oldOrder = orders.set(index, newOrder);
		System.out.println("Replaced: " + oldOrder + " ➜ " + newOrder);
	}

	public static void main(String[] args) {
		OrderHistory history = new OrderHistory();

		history.addOrder(new Order(101, "Laptop", 1200.00));
		history.addOrder(new Order(102, "Smartphone", 800.00));
		history.addOrder(new Order(103, "Headphones", 150.00));

		history.displayOrders();

		history.removeOldestOrder();

		history.displayOrders();

		history.setOrder(1, new Order(202, "Tablet", 600.00));

		System.out.println("\nAfter replacement:");
		history.displayOrders();
	}

}
