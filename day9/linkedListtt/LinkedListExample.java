package com.day9.linkedListtt;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> callHistory = new LinkedList<String>();
		callHistory.add("Kranthi");
		callHistory.add("Anand");
		callHistory.add("Sravan");
		callHistory.add("Nisha");
		callHistory.add("Chitti");

		System.out.println(callHistory);
		System.out.println(callHistory.size());
		System.out.println(callHistory.getFirst());
		System.out.println(callHistory.getLast());
		
		callHistory.set(2, "Kranthi Kumar");
		System.out.println(callHistory);
		System.out.println(callHistory.size());
		
		callHistory.add(2, "Mamidi");
		System.out.println(callHistory);
		System.out.println(callHistory.size());
	}

}
