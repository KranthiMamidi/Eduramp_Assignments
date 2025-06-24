package com.day4;

public class IndexExceptionExample {

	public static void main(String[] args) {
//		int[] arr = new int[5];
//		arr[0] = 99;
//		arr[1] = 88;
//		arr[3] = 55;
//		arr[4] = 32;
//		arr[5] = 675;

		try {
			int[] arr1 = new int[5];
			arr1[0] = 99;
			arr1[1] = 88;
			arr1[3] = 55;
			arr1[4] = 32;
			arr1[5] = 675;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			System.out.println("Hello ");
		}

	}

}
