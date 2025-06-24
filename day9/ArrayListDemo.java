package com.day9;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Kranthi");
		names.add("Anand");
		names.add("Sravan");
		names.add("Chitti");
		names.add("Manoj");
		
		System.out.println(names);

		names.add(4, "Pranali");
		System.out.println(names);

		System.out.println(names.get(4));

		names.set(4, "Manoj");
		System.out.println(names);

		names.add("Pranali");
		System.out.println(names);

		names.remove("Manoj");
		System.out.println(names);

		System.out.println(names.indexOf("Kranthi"));

		System.out.println(names.isEmpty());
		
		names.clear();
		System.out.println(names);
		

	}
}
