package com.day19.telecomDesignPatternUsage;

import java.util.ArrayList;
import java.util.List;

public class NetworkMoniteringSystem {

	private List<Subscriber> sub = new ArrayList<>();

	public void registerSubscriber(Subscriber s) {
		sub.add(s);
	}

	public void removeSubscriber(Subscriber s) {
		sub.remove(s);
	}

	public void notifyAllSubscribers(String message) {
		for (Subscriber s : sub) {
			s.update(message);
		}
	}

	public void detectNetworkOutage() {
		System.out.println("Network outage detected..");
		notifyAllSubscribers("Network outage in your area from 5:00 pm  to 10:00 pm our team is working on it");
	}
}
