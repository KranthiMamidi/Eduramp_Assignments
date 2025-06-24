package com.day8;

public class ConsumerThread extends Thread {

	private ProducerConsumerProblem pc;

	public ConsumerThread(ProducerConsumerProblem pc) {
		super();
		this.pc = pc;
	}

	public void run() {
		int value = 0;
		try {
			while (true) {
				pc.consume();
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
