package com.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileIOExamples {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("FirstExample");
		FileOutputStream stream = new FileOutputStream("FileOutPut");
	}

}
