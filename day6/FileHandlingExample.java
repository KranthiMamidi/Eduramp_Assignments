package com.day6;

import java.io.*;
import java.nio.file.*;

public class FileHandlingExample {

	public static void main(String[] args) {
		String fileName = "sample.txt";

		// 1. Create a File
		createFile(fileName);

		// 2. Write to the File
		writeToFile(fileName, "Hello, this is a file handling example using FileOutputStream.");

		// 3. Read from the File
		readFromFile(fileName);

		// 4. Delete the File
//		deleteFile(fileName);
	}

	// Method to create a file
	public static void createFile(String fileName) {
		try {
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created successfully: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("Error while creating file.");
			e.printStackTrace();
		}
	}

	// Method to write using FileOutputStream
	public static void writeToFile(String fileName, String content) {
		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			byte[] bytes = content.getBytes();
			fos.write(bytes);
			System.out.println("Data written to file.");
		} catch (IOException e) {
			System.out.println("Error while writing to file.");
			e.printStackTrace();
		}
	}

	// Method to read using FileInputStream
	public static void readFromFile(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName)) {
			System.out.println("Reading from file:");
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("Error while reading from file.");
			e.printStackTrace();
		}
	}

	// Method to delete file
	public static void deleteFile(String fileName) {
		try {
			Files.deleteIfExists(Paths.get(fileName));
			System.out.println("File deleted successfully.");
		} catch (IOException e) {
			System.out.println("Error while deleting file.");
			e.printStackTrace();
		}
	}
}