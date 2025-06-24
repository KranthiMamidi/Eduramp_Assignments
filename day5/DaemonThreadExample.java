package com.day5;

class LoggerThread extends Thread {
	public void run() {
		while (true) {
			System.out.println("Logging system status...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Logger interrupted.");
			}
		}
	}
}

class BankOperation extends Thread {
	public void run() {
		System.out.println("Performing bank operation: Deposit ₹5000");
		try {
			Thread.sleep(10000); // simulate operation delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Bank operation completed.");
	}
}

public class DaemonThreadExample {
	public static void main(String[] args) {
		LoggerThread logger = new LoggerThread();
		logger.setDaemon(true); // Marking as daemon thread
		BankOperation bankTask = new BankOperation();

		System.out.println("Is Logger Daemon? " + logger.isDaemon());

		logger.start(); // background logger
		bankTask.start(); // main task

		try {
			bankTask.join(); // wait for main task
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread ends. JVM will exit, stopping daemon thread.");
	}
}