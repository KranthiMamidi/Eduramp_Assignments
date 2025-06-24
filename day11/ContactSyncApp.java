package com.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContactSyncApp {
	public static void main(String[] args) {

		String[] simContacts = { "Kranthi", "Anand", "Sravan", "Manoj" };

		String[] googleContacts = { "Chitti", "Pranali", "Ramya", "Chandu", "Kranthi" };

		String[] phoneContacts = { "Nisha", "Rajani", "Madan", "Kumar" };

		Set<String> uniqueContacts = new HashSet<String>(Arrays.asList(simContacts));

		uniqueContacts.addAll(Arrays.asList(googleContacts));

		uniqueContacts.addAll(Arrays.asList(phoneContacts));

		System.out.println(uniqueContacts);

		Set<String> uniqueOrderContacts = new TreeSet<String>(uniqueContacts);
		System.out.println(uniqueOrderContacts);

	}

}
