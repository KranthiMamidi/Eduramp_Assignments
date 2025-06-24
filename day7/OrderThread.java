package com.day7;

public class OrderThread extends Thread {

	private Inventory inventory;

	double pricePerItem = 20.0;

	String user;

	int quantity;

	public OrderThread(Inventory inventory, String user, int quantity) {
		super();
		this.inventory = inventory;
		this.user = user;
		this.quantity = quantity;
	}

	public void run() {
		inventory.purchase(user, quantity, pricePerItem);
	}

	public static void main(String[] args) {
		Inventory inv = new Inventory();

//		OrderThread thread1 = new OrderThread(inv, "Kranthi", 30);
//		thread1.start();
//
////		Thread thread= new Thread(thread1);
////		thread.start();
//
//		OrderThread thread2 = new OrderThread(inv, "Anand", 77);
//		thread2.start();

		OrderThread thread1 = new OrderThread(inv, "Kranthi", 30);
		thread1.start();
		OrderThread thread2 = new OrderThread(inv, "Anand", 77);
		thread2.start();
		
		OrderThread thread3 = new OrderThread(inv, "Sravan", 30);
		thread3.start();
	}
}
