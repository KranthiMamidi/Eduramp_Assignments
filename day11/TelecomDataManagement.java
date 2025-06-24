package com.day11;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelecomDataManagement {

	public static void main(String[] args) {

		Set<String> customerNumbers = new HashSet<>();
		customerNumbers.add("9876543210");
		customerNumbers.add("9123456789");
		customerNumbers.add("9876543210");
		customerNumbers.add("8000000000");

		Set<String> blockedSpamNumbers = new TreeSet<>();
		blockedSpamNumbers.add("9000000001");
		blockedSpamNumbers.add("9000000002");
		blockedSpamNumbers.add("8000000000");
		blockedSpamNumbers.add("9000000001");

		Set<String> activeZones = new TreeSet<>();
		activeZones.add("Zone-C");
		activeZones.add("Zone-A");
		activeZones.add("Zone-B");
		activeZones.add("Zone-A");

		System.out.println("Unique Customer Numbers (HashSet):");
		for (String number : customerNumbers) {
			System.out.println(number);
		}

		System.out.println("\nBlocked Spam Numbers (TreeSet - Sorted):");
		for (String spam : blockedSpamNumbers) {
			System.out.println(spam);
		}

		System.out.println("\nActive Network Zones (TreeSet - Sorted):");
		for (String zone : activeZones) {
			System.out.println(zone);
		}
	}
}
