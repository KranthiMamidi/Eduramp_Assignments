package com.day19.telecomDesignPatternUsage;

public class TelecomObserverSystem {

	public static void main(String[] args) {
		NetworkMoniteringSystem system = new NetworkMoniteringSystem();

		Subscriber user1 = new PrepaidUser("Kranthi");
		Subscriber user2 = new PostPaidUser("Chitti");
		Subscriber user3 = new CorporateClient("Pranali");

		system.registerSubscriber(user1);
		system.registerSubscriber(user2);
		system.registerSubscriber(user3);

		system.detectNetworkOutage();
	}
}
