package com.day19.newsSubscription;

public class User implements Subscriber {

	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void update(String news) {
		System.out.println(name + "received news : " + news);
	}

}
