package com.day11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UserClass {

	String name;
	long phoneNumber;
	String email;

	public UserClass(String name, long phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserClass [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public static void main(String[] args) {

		UserClass user1 = new UserClass("Kranthi", 9966889852L, "kranthi@gmail.com");

		UserClass user2 = new UserClass("Sravan", 9988776655L, "sravan@gmail.com");

		UserClass user3 = new UserClass("Anand", 8877544865L, "anand@gmail.com");

		UserClass user4 = new UserClass("Manoj", 970387766L, "manoj@gmail.com");

		UserClass[] userArray = { user1, user2, user3, user4, user2 };

		for (UserClass userClass : userArray) {
			System.out.println(userClass);
		}

		System.out.println();

		Set<UserClass> userSet = new HashSet<UserClass>();

		for (UserClass userClass : userArray) {
			userSet.add(userClass);
		}

		System.out.println(userSet);
		
		Set<UserClass> userLinkedSet = new LinkedHashSet<UserClass>();

		for (UserClass userClass : userArray) {
			userLinkedSet.add(userClass);
		}

		System.out.println(userLinkedSet);
		
		
//		Set<UserClass> userTreeSet = new TreeSet<UserClass>();
//		
//		for (UserClass userClass : userArray) {
//			userTreeSet.add(userClass);
//		}
//		System.out.println(userTreeSet);
	}

}
