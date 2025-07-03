package com.day19.telecomDesignPatternUsage;

public class PostPaidUser implements Subscriber {

	private String name;

	public PostPaidUser(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println("Postpaid user [" + name + "] received alert " + message);
	}

}
