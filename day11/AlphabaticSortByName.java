package com.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Contact1 {
	private String name;
	private String phoneNumber;
	private String email;
	private String department;

	public Contact1(String name, String phoneNumber, String email, String department) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Contact1))
			return false;
		Contact1 contact = (Contact1) o;
		return name.equalsIgnoreCase(contact.name) && phoneNumber.equals(contact.phoneNumber);
	}

	@Override
	public String toString() {
		return "Contact1 [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", department="
				+ department + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase(), phoneNumber);
	}

}

public class AlphabaticSortByName {

	public static void main(String[] args) {

		Contact1[] simContacts = { new Contact1("Jeevan", "9876543210", "jeevan@sim.com", "HR"),
				new Contact1("Nisha", "9123456789", "nisha@sim.com", "IT"),
				new Contact1("Chitti", "9988776655", "chitti@sim.com", "Finance") };

		Contact1[] googleContacts = { new Contact1("Jaya", "9876543210", "jaya@sim.com", "HR"),
				new Contact1("Nivetha", "9123456789", "nivi@sim.com", "IT"),
				new Contact1("Chitti", "9988776655", "chitti@sim.com", "Finance") };

		Contact1[] phoneContacts = { new Contact1("Srinivas", "9876543210", "srinivas@sim.com", "HR"),
				new Contact1("Chityala", "9123456789", "chityala@sim.com", "IT"),
				new Contact1("Nivetha", "9123456789", "nivi@sim.com", "Finance") };

		Set<Contact1> uniqueContacts = new HashSet<Contact1>();

		Collections.addAll(uniqueContacts, simContacts);
		Collections.addAll(uniqueContacts, googleContacts);
		Collections.addAll(uniqueContacts, phoneContacts);

		List<Contact1> sortedContact = new ArrayList<Contact1>(uniqueContacts);
		sortedContact.sort(Comparator.comparing(Contact1::getName, String.CASE_INSENSITIVE_ORDER));
		System.out.println(sortedContact);

		System.out.println();

		Map<String, List<Contact1>> contactsByDepartment = new HashMap<>();

		for (Contact1 contact1 : uniqueContacts) {
			if (contactsByDepartment.containsKey(contact1.getDepartment())) {
				contactsByDepartment.get(contact1.getDepartment()).add(contact1);
			} else {
				contactsByDepartment.put(contact1.getDepartment(), new ArrayList<Contact1>());
				contactsByDepartment.get(contact1.getDepartment()).add(contact1);
			}
		}

		for (Map.Entry<String, List<Contact1>> entry : contactsByDepartment.entrySet()) {
			String department = entry.getKey();
			List<Contact1> contactList = entry.getValue();

			System.out.println("Department: " + department);
			for (Contact1 contact : contactList) {
				System.out.println("  " + contact);
			}
		}

	}

}
