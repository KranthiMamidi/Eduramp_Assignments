package com.day8;

public class ProducerThread extends Thread {
	
	private ProducerConsumerProblem pc;

	public ProducerThread(ProducerConsumerProblem pc) {
		super();
		this.pc = pc;
	}

	public void run() {
		int value = 0;
		try {
			while (true) {
				pc.produce(value++);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
