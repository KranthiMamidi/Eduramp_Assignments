package com.day13;

import java.util.Vector;

public class VectorExamples {

	public static void main(String[] args) {

		Vector<String> animals = new Vector<>();
		animals.add("Lion");
		animals.add("Tiger");
		animals.add("Rabbit");

		System.out.println(animals);

		animals.add("Deer");

		System.out.println(animals);

		animals.add(0, "Dog");

		System.out.println(animals);

		System.out.println(animals.contains("cat"));
		System.out.println(animals.contains("Lion"));
	}

}
