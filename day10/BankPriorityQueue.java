package com.day10;

import java.util.PriorityQueue;

class Customer implements Comparable<Customer> {

	String name;
	int priority;

	public Customer(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;

	}

	@Override
	public int compareTo(Customer name) {
		return Integer.compare(this.priority, name.priority);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", priority=" + priority + "]";
	}

}

public class BankPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Customer> queue = new PriorityQueue();
		queue.add(new Customer("Pawan : Premium", 1));
		queue.add(new Customer("Madan : Regular", 3));
		queue.add(new Customer("Jaya : Sr citizen", 1));
		queue.add(new Customer("Ramya: New Inquiry", 4));
		System.out.println("Serve customer in order");
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}