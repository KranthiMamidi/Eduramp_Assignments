package com.day10;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInJava {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("Kranthi");
		queue.offer("Kranthi");
		System.out.println(queue);
	}

}
