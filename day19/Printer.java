package com.day19;

public class Printer {

	private static Printer printerInstance;

	private Printer() {
		System.out.println("Printer private Constructor...");
	}

	public static Printer getPrinterInstance() {

		if (printerInstance == null) {
			printerInstance = new Printer();
		}
		return printerInstance;
	}

	public void print(String document) {
		System.out.println("Printing: " + document);
	}
}
