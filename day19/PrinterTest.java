package com.day19;

public class PrinterTest {

	public static void main(String[] args) {

		Printer p1 = Printer.getPrinterInstance();
		p1.print("Document 1");

		Printer p2 = Printer.getPrinterInstance();
		p2.print("Document 1");
		
		System.out.println(p1==p2);
	}

}
