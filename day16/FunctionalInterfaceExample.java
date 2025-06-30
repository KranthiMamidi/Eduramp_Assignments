package com.day16;

interface A {
	// Single abstract method and static and default methods in it
	void show();

}

//class Calc implements A{
//
//	@Override
//	public void show() {
//		System.out.println("Showing the calculation!");
//		
//	}
//	

//}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		A obj;
		obj = new A() // Anonymous class
		{
			@Override
			public void show() {
				System.out.println("Show");
			}
		};
		obj.show();

		A obj2 = () -> System.out.println("show2");
		obj2.show();
	}
}
