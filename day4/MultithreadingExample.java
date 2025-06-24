package com.day4;

class User extends Thread {
	int user_no = 1001;
	String user_name = "Preetti";

	public void run() {
		System.out.println(user_no + "" + user_name);
	}

}

public class MultithreadingExample {
	public static void main(String[] args) {
		User user1 = new User();
		user1.start();
		user1.stop();
		// user1.start();
	}

}
