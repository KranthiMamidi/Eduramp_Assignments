package com.day13;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.List;

//why sorting 

class Product {

	String name;

	double price;

	public Product(String name, double price) {

		super();

		this.name = name;

		this.price = price;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public double getPrice() {

		return price;

	}

	public void setPrice(double price) {

		this.price = price;

	}

	@Override

	public String toString() {

		return "Product [name=" + name + ", price=" + price + "]";

	}

}

public class SortExample {

	public static void main(String[] args) {

		List<Product> sort_price = new ArrayList<>();

		sort_price.add(new Product("Laptops", 30000));

		sort_price.add(new Product("Mobile", 50000));

		sort_price.add(new Product("Mouse", 2000));

		System.out.println(sort_price);

		sort_price.sort(Comparator.comparingDouble(p -> p.price));

		System.out.println("Sorted by price");

		for (Product p : sort_price) {

			System.out.println(p);

		}

	}

}
