package com.day19.newsSubscription;

import java.util.ArrayList;
import java.util.List;

public class TOI implements NewsAgency {

	private List<Subscriber> subscribers = new ArrayList<>();

	@Override
	public void subscribe(Subscriber s) {
		subscribers.add(s);
		System.out.println(((User) s).getName() + " subscribed to TOI News");
	}

	@Override
	public void unSubscribe(Subscriber s) {
		subscribers.remove(s);
		System.out.println(((User) s).getName() + " unSubscribed to TOI News");

	}

	@Override
	public void publishNews(String news) {
		System.out.println("Breaking News.......!");
		for (Subscriber subscriber : subscribers) {
			subscriber.update(news);
		}
	}

}
