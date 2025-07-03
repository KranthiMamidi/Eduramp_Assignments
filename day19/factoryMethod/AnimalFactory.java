package com.day19.factoryMethod;

public class AnimalFactory {

	public static Animal getAnimal(String type) {
		if ("dog".equalsIgnoreCase(type)) {
			return new Dog();
		} else if ("cat".equalsIgnoreCase(type)) {
			return new Cat();
		}
		return null;
	}
}
