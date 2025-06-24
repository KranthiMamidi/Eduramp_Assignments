package com.day8;

import java.util.LinkedList;

public class ProducerConsumerProblem {

	private static final int capacity = 10;
	private final LinkedList<Integer> buffer = new LinkedList();

	synchronized void produce(int value) throws InterruptedException {
//		synchronized (buffer) {
		while (buffer.size() == capacity) {
			wait();
		}
		buffer.add(value);
		System.out.println("Product " + value);
		notify();
//		}
	}

	synchronized public void consume() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();
		}
		int value = buffer.removeFirst();
		System.out.println("Product Consumed " + value);
		notify();
	}
}
