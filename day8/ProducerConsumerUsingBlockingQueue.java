package com.day8;

import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.BlockingQueue;
 
public class ProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Integer> data = new ArrayBlockingQueue(5);

		// producer

		Runnable producer = () -> {

			int value = 0;

			try {

				while(true) {

					data.put(value);

					System.out.println("Produce" +value);

					value++;

					Thread.sleep(1000);

				}

			}

				catch(InterruptedException ie) {

					ie.printStackTrace();

				}

		};

		//consumer

		Runnable consumer = () -> {

			try {

				while(true) {

					int value = data.take(); //blocks if empty

					System.out.println("Consume" +value);

					Thread.sleep(1000);

				}

			}

			catch (InterruptedException ie) {

				ie.printStackTrace();

			}

		};

		new Thread(consumer).start();

		new Thread(producer).start();

	}
 
}

 