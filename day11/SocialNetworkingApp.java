package com.day11;

public class SocialNetworkingApp {

	public static void main(String[] args) {
		User user = new User("Kranthi");

		user.addInterest("Reading");
		user.addInterest("Cooking");
		user.addInterest("Traveling");
		user.addInterest("reading");
		user.addInterest("   Cooking ");

		user.removeInterest("dancing");
		user.removeInterest("Traveling");

		System.out.println("--- Final User Profile ---");
		System.out.println(user);
	}

}
