package com.day16.TelecomRecharge;

/**
 * 
 */
public class RechargePlan {

	private int id;
	private String name;
	private double price;
	private int validity;
	private double datalimit;
	private int smsPerDay;
	private boolean unlimitedCalls;
	private boolean includeOTT;

	public RechargePlan() {
		super();
	}

	public RechargePlan(int id, String name, double price, int validity, double datalimit, int smsPerDay,
			boolean unlimitedCalls, boolean includeOTT) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.validity = validity;
		this.datalimit = datalimit;
		this.smsPerDay = smsPerDay;
		this.unlimitedCalls = unlimitedCalls;
		this.includeOTT = includeOTT;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getValidity() {
		return validity;
	}

	public double getDatalimit() {
		return datalimit;
	}

	public int getSmsPerDay() {
		return smsPerDay;
	}

	public boolean isUnlimitedCalls() {
		return unlimitedCalls;
	}

	public boolean isIncludeOTT() {
		return includeOTT;
	}

	@Override
	public String toString() {
		return "RechargePlan [id=" + id + ", name=" + name + ", price=" + price + ", validity=" + validity
				+ ", datalimit=" + datalimit + ", smsPerDay=" + smsPerDay + ", unlimitedCalls=" + unlimitedCalls
				+ ", includeOTT=" + includeOTT + "]";
	}

	
}
