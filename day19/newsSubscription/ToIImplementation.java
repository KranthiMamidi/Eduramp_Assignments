package com.day19.newsSubscription;

public class ToIImplementation {

	public static void main(String[] args) {
		NewsAgency toi = new TOI();

		Subscriber kranthi = new User("Kranthi");

		Subscriber manoj = new User("Manoj");

		Subscriber pranali = new User("Pranali");

		toi.subscribe(pranali);
		toi.subscribe(manoj);
		toi.subscribe(kranthi);

		toi.publishNews("News News News !!!!!!!!!!!!");

		toi.unSubscribe(kranthi);

		toi.publishNews("News News News !!!....");
	}
}
