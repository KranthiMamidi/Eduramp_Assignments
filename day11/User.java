package com.day11;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {
	private final String username;
	private final Set<String> interests;

	public User(String username) {
		this.username = username;
		this.interests = new HashSet<>();
	}

	public boolean addInterest(String interest) {
		String normalized = normalizeInterest(interest);
		boolean added = interests.add(normalized);
		if (added) {
			System.out.println("Added interest: " + normalized);
		} else {
			System.out.println("Interest already exists: " + normalized);
		}
		return added;
	}

	public boolean removeInterest(String interest) {
		String normalized = normalizeInterest(interest);
		boolean removed = interests.remove(normalized);
		if (removed) {
			System.out.println("Removed interest: " + normalized);
		} else {
			System.out.println("Interest not found: " + normalized);
		}
		return removed;
	}

	private String normalizeInterest(String interest) {
		return interest.trim().toLowerCase();
	}

	public Set<String> getInterests() {
		return Collections.unmodifiableSet(interests);
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User: " + username + "\nInterests: " + interests;
	}
}
