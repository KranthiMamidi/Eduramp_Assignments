package com.day12;

import java.util.HashMap;
import java.util.Map;

class Product {
	String name;
	int price;
	int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

}

public class ProductInventory {
	public static void main(String[] args) {
		Map<String, Product> inventory = new HashMap();
		inventory.put("P001", new Product("GT Neo 2", 28999, 14));
		inventory.put("P002", new Product("S25", 54999, 25));
		inventory.put("P003", new Product("S25 Ultra", 125000, 10));
		inventory.put("P004", new Product("S25 Edge", 10000, 50));

		String searchID = "P008";
		Product searchProduct = inventory.get(searchID);

		if (searchProduct != null) {
			System.out.println("Product Found : " + searchProduct);
		} else {
			System.out.println("Product not Found with Id: " + searchID);
		}
	}

}
