package com.day19.telecom;

import java.time.LocalDateTime;

public class Logger {

	private static Logger instance;

	private Logger() {
		System.out.println("Logger Initialized");
	}

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void info(String message) {
		System.out.println(LocalDateTime.now() + " [INFO] " + message);
	}

	public void error(String message) {
		System.out.println(LocalDateTime.now() + " [ERROR] " + message);
	}
}
