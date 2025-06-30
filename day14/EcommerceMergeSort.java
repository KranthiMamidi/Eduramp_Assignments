package com.day14;

import java.util.Date;

class Order {
	int orderId;
	Date orderDate;

	public Order(int orderId, Date orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + ", Date: " + orderDate;
	}
}

public class EcommerceMergeSort {

	public static void main(String[] args) {
		Order[] orders = new Order[] { new Order(101, new Date(2024 - 1900, 11, 10)), // Dec 10, 2024
				new Order(102, new Date(2024 - 1900, 5, 25)), // Jun 25, 2024
				new Order(103, new Date(2024 - 1900, 2, 15)), // Mar 15, 2024
				new Order(104, new Date(2024 - 1900, 7, 2)) // Aug 2, 2024
		};

		System.out.println("Before Sorting:");
		printOrders(orders);

		mergeSort(orders, 0, orders.length - 1);

		System.out.println("\nAfter Sorting by Order Date:");
		printOrders(orders);
	}

	// Merge Sort for Order array
	public static void mergeSort(Order[] orders, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(orders, left, mid);
			mergeSort(orders, mid + 1, right);
			merge(orders, left, mid, right);
		}
	}

	// Merge function for Order[]
	public static void merge(Order[] orders, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		Order[] leftArr = new Order[n1];
		Order[] rightArr = new Order[n2];

		for (int i = 0; i < n1; i++)
			leftArr[i] = orders[left + i];
		for (int j = 0; j < n2; j++)
			rightArr[j] = orders[mid + 1 + j];

		int i = 0, j = 0, k = left;

		// Compare by orderDate
		while (i < n1 && j < n2) {
			if (leftArr[i].orderDate.before(rightArr[j].orderDate)) {
				orders[k++] = leftArr[i++];
			} else {
				orders[k++] = rightArr[j++];
			}
		}

		while (i < n1)
			orders[k++] = leftArr[i++];
		while (j < n2)
			orders[k++] = rightArr[j++];
	}

	// Utility to print orders
	public static void printOrders(Order[] orders) {
		for (Order o : orders)
			System.out.println(o);
	}
}