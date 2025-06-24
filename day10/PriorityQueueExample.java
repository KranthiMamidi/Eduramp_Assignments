package com.day10;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Integer> nums = new PriorityQueue<Integer>();
		nums.add(99);
		nums.add(88);
		nums.add(82);
		System.out.println(nums);
		
		System.out.println(nums.poll());
	}

}
