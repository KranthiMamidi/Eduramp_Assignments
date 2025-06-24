package com.day9;

import java.util.ArrayList;
import java.util.List;

public class ArrayListProductDemo {

	List<String> product = new ArrayList<String>(100);

	public void addProduct(String item) {
		product.add(item);
	}

	public void removeProduct(int index) {
		product.remove(index);
	}

	public void showCart() {
		for (String string : product) {
			System.out.println(string);
		}
	}

	public void setProduct(int slot, String newProduct) {
		product.set(slot, newProduct);
	}

	public String getProductFromAL(int slot) {
		System.out.println(product.get(slot));
		return product.get(slot);
	}

	public static void main(String[] args) {
		ArrayListProductDemo house = new ArrayListProductDemo();

		house.showCart();
		house.addProduct("Mobile");
		house.addProduct("Bottle");
		house.addProduct("Book");
		house.addProduct("Pen");
		house.addProduct("Charger");
		house.addProduct("Phone");
		house.removeProduct(3);
		house.showCart();
	}

}
