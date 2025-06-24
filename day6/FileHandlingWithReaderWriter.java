package com.day6;

import java.io.*;
import java.nio.file.*;

public class FileHandlingWithReaderWriter {

	public static void main(String[] args) {
		String fileName = "demo.txt";

		// 1. Create File
		createFile(fileName);

		// 2. Write to File
		writeToFile(fileName, "This is an example using FileWriter and FileReader in Java.");

		// 3. Read from File
		readFromFile(fileName);

		// 4. Delete File
		deleteFile(fileName);
	}

	// Method to create a new file
	public static void createFile(String fileName) {
		try {
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created: " + fileName);
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file.");
			e.printStackTrace();
		}
	}

	// Method to write to the file using FileWriter
	public static void writeToFile(String fileName, String content) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write(content);
			System.out.println("Successfully written to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}

	// Method to read from the file using FileReader
	public static void readFromFile(String fileName) {
		try (FileReader reader = new FileReader(fileName)) {
			System.out.println("Reading from file:");
			int ch;
			while ((ch = reader.read()) != -1) {
				System.out.print((char) ch);
			}
			System.out.println(); // New line after file content
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		}
	}

	// Method to delete the file
	public static void deleteFile(String fileName) {
		try {
			Files.deleteIfExists(Paths.get(fileName));
			System.out.println("File deleted successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while deleting the file.");
			e.printStackTrace();
		}
	}
}