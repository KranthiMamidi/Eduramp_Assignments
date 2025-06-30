package com.day14;

import java.util.Arrays;

public class MergeSortExample {

	public static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {
			// find middle point
			int mid = left + (right - left) / 2;

			// sort first and second halves
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}

	}

	public static void merge(int[] arr, int left, int mid, int right) {
		// size of 2 sub arrays
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// temp arrays
		int leftArr[] = new int[n1];
		int rightArr[] = new int[n2];

		// copy data into temp arrays
		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}

		for (int i = 0; i < n2; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}

		// merge temporary arrays

		int i = 0;
		int j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[]
		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[]
		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 6, 92, 2, 93, 33, 4 };
		printArray(arr);

		mergeSort(arr, 0, arr.length - 1);

		printArray(arr);
	}

}
