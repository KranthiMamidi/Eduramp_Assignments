package com.day4;

class Userr implements Runnable {
	int user_no = 1001;
	String user_name = "Preetti";

	public void run() {
		System.out.println(user_no + "" + user_name);
	}

}

public class MultithreadingExample2 {
	public static void main(String[] args) {
		Userr user1 = new Userr();
		Thread t1 = new Thread(user1);
		t1.start();
		t1.stop();
		// user1.start();
	}
	// difference between thread class and runnable interface

}
