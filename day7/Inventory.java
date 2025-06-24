package com.day7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {

	private int stock = 100;
	Lock lock = new ReentrantLock();

	private Payment payment = new Payment();

//	public void purchase(String user, int quantity) {
//		try {
//			lock.lock();
//			if (stock >= quantity) {
//				System.out.println(user + " has purchased " + quantity + " item");
//				stock -= quantity;
//			} else {
//				System.out.println("Available stock(" + stock + ") is less than the requires stock(" + quantity + ")");
//			}
//		} catch (Exception e) {
//
//		} finally {
//			lock.unlock();
//		}
//
//	}

	public synchronized void purchase(String user, int qty, double pricePerItem) {
		if (stock >= qty) {
			double totalAmount = qty * pricePerItem;

			if (payment.processPayment(user, totalAmount)) {
				System.out.println(user + " purchased " + qty + " item(s) for a total of " + totalAmount);
				stock -= qty;
				System.out.println("Remaining stock: " + stock);
			} else {
				System.out.println("Payment failed for " + user);
			}
		} else {
			System.out.println("Not enough stock for " + user + "!");
		}
	}
}
