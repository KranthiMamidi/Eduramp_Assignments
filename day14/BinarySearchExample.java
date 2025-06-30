package com.day14;

import java.util.Arrays;

public class BinarySearchExample {

	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid; // Target found
			} else if (arr[mid] < target) {
				low = mid + 1; // Search right half
			} else {
				high = mid - 1; // Search left half
			}
		}

		return -1; // Target not found
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 4, 7, 10, 14, 18, 20, 66, 43 };

		// Step 1: Sort the array before binary search
		Arrays.sort(numbers); // Now the array is [2, 4, 7, 10, 14, 18, 20, 43, 66]

		int target = 66;

		int result = binarySearch(numbers, target);

		if (result == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index: " + result);
		}
	}
}
