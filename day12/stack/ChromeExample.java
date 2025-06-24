package com.day12.stack;

import java.util.Stack;

public class ChromeExample {
	Stack<String> backStack = new Stack();
	Stack<String> forwardStack = new Stack();

	String currentPage = "Home";

	public void back() {
		if (!backStack.isEmpty()) {
			forwardStack.push(currentPage);
			currentPage = backStack.pop();
			System.out.println("Went back to : " + currentPage);
		} else {
			System.out.println("Non pages to go back");
		}
	}

	public void forward() {
		if (!forwardStack.isEmpty()) {
			backStack.push(currentPage);
			currentPage = forwardStack.pop();
			System.out.println("Went Forward to : " + currentPage);
		} else {
			System.out.println("No Pages to go to forward");
		}
	}

	public void currentPage() {
		System.out.println("Current Page : " + currentPage);
	}

	public void visit(String url) {
		backStack.push(currentPage);
		currentPage = url;
		forwardStack.clear();
		System.out.println("Visited : " + currentPage);
	}

	public static void main(String[] args) {

		ChromeExample history = new ChromeExample();
		history.visit("Google.com");
		history.visit("OpenAI.com");
		history.visit("GitHub");

		history.back();
		history.back();
		history.back();
		history.back();

		history.forward();
		history.forward();
		history.visit("StackOverFlow");
		history.forward();

		System.out.println();
		history.currentPage();

	}
}
