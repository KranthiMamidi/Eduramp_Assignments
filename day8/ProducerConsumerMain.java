package com.day8;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		ProducerConsumerProblem problem1 = new ProducerConsumerProblem();
		new ProducerThread(problem1).start();
		new ConsumerThread(problem1).start();
	}
}
