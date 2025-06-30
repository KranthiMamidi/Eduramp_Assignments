package com.day16;

import java.util.Arrays;
import java.util.List;

public class JavaEightFeatures {
	
	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 4, 3, 66, 93, 44);

		nums.forEach(i -> System.out.println(i));
	}

}
