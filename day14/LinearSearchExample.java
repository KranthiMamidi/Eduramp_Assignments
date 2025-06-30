package com.day14;

public class LinearSearchExample {

	public static int linearSearch(int[] arr, int target) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i; // Found, return index
			}
		}
		return -1; // Not found
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 4, 7, 10, 14, 18, 20, 66, 43 };
		int target = 66;

		int result = linearSearch(numbers, target);

		if (result == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index: " + result);
		}
	}
}
