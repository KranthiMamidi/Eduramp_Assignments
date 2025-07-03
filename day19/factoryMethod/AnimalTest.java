package com.day19.factoryMethod;

public class AnimalTest {

	public static void main(String[] args) {
		Animal animal1 = AnimalFactory.getAnimal("dog");
		animal1.speak();

		Animal animal2 = AnimalFactory.getAnimal("cat");
		animal2.speak();
	}

}
