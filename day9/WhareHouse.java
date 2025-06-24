package com.day9;

import java.util.ArrayList;
import java.util.List;

public class WhareHouse {
	String[] productSlots = new String[100];


	public void storeProduct(int slot, String product) {
		productSlots[slot] = product;
	}

	public String getProduct(int slot) {
		System.out.println(productSlots[slot]);
		return productSlots[slot];
	}

	public static void main(String[] args) {

		WhareHouse house = new WhareHouse();
		house.storeProduct(32, "Mango");
		house.getProduct(32);

	}

}
