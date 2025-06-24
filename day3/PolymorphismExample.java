package com.day3;

class Calculator {
	public int add(int a, int b) {
		System.out.println(a + b);
		return a + b;
	}

	public float add(float a, float b) {
		return a + b;
	}

	public int add(int a, int b, int c) {
		return a + b + c;
	}
}

public class PolymorphismExample extends Calculator {

	@Override
	public int add(int a, int b) {
		System.out.println(a + b);
		return a + b + 1;
	}

	public static void main(String[] args) {
		PolymorphismExample example = new PolymorphismExample();
		System.out.println(example.add(1, 2));
	}
}