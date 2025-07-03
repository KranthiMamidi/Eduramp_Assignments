package com.day19.telecomDesignPatternUsage;

public class CorporateClient implements Subscriber {

	private String company;

	public CorporateClient(String company) {
		super();
		this.company = company;
	}

	@Override
	public void update(String message) {
		System.out.println("Corporate client [" + company + "] received alert " + message);

	}

}
