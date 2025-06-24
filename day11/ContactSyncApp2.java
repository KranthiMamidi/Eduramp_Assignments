package com.day11;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Objects;

// Contact class with name, phone number, and email
class Contact {
	private String name;
	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	// Getters (can be used later if needed)
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	// Overriding equals() to compare name + phone number
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (!(o instanceof Contact))
//			return false;
//		Contact contact = (Contact) o;
//		return name.equalsIgnoreCase(contact.name) && phoneNumber.equals(contact.phoneNumber);
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Contact))
			return false;
		Contact contact = (Contact) o;
		return name.equalsIgnoreCase(contact.name) && phoneNumber.equals(contact.phoneNumber)
				&& email.equalsIgnoreCase(contact.email);
	}

	// Overriding hashCode() to be consistent with equals()
	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase(), phoneNumber);
	}

	@Override
	public String toString() {
		return name + " | " + phoneNumber + " | " + email;
	}
}

public class ContactSyncApp2 {

	public static void main(String[] args) {

		// Contacts from SIM
		Contact[] simContacts = { new Contact("Jeevan", "9876543210", "jeevan@sim.com"),
				new Contact("Nisha", "9123456789", "nisha@sim.com"),
				new Contact("Chitti", "9988776655", "chitti@sim.com") };

		// Contacts from Google
		Contact[] googleContacts = { new Contact("Jaya", "9876543210", "jaya@sim.com"),
				new Contact("Nivetha", "9123456789", "nivi@sim.com"),
				new Contact("Chitti", "9988776655", "chitti@sim.com") // Duplicate
		};

		// Contacts from Outlook
		Contact[] phoneContacts = { new Contact("Srinivas", "9876543210", "srinivas@sim.com"),
				new Contact("Chityala", "9123456789", "chityala@sim.com"),
				new Contact("Nivetha", "9123456789", "nivi@sim.co") };

		// Set to store only unique contacts
		Set<Contact> uniqueContacts = new LinkedHashSet<>();

		// Merge all contacts into the set
		for (Contact c : simContacts)
			uniqueContacts.add(c);
		for (Contact c : googleContacts)
			uniqueContacts.add(c);
		for (Contact c : phoneContacts)
			uniqueContacts.add(c);

		// Display the synced contacts
		System.out.println(" Synced Unique Contacts:");
		for (Contact contact : uniqueContacts) {
			System.out.println("- " + contact);
		}

	}
}
