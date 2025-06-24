package com.day2;

abstract class MobileNetwork {

	public void showSinal() {
		System.out.println("You have full signal");
	}

	abstract void welcomeMessage();
}

public class Jio extends MobileNetwork {

	@Override
	void welcomeMessage() {
		System.out.println("Welcome to Jio");
	}

	public static void main(String[] args) {
		Jio jio = new Jio();
		jio.showSinal();
		jio.welcomeMessage();
	}

}
