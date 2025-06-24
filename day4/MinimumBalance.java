package com.day4;

import java.util.*;

class MinBalanceException extends Exception {

	public MinBalanceException(String message) {
		super(message);
	}
}

public class MinimumBalance {
	public static void main(String[] args) {
		int acc[] = { 100, 101, 102, 103, 104 };
		double balance[] = { 900, 800, 1500, 1560, 1765.50 };
		List<String> lowBalanceAccounts = new ArrayList<>();

		System.out.println("Account No\tBalance");

		for (int i = 0; i < balance.length; i++) {
			System.out.println(acc[i] + "\t\t" + balance[i]);

			if (balance[i] < 1000) {
				lowBalanceAccounts.add("Account " + acc[i] + " has low balance: " + balance[i]);
			}
		}

		if (!lowBalanceAccounts.isEmpty()) {
			try {
				throw new MinBalanceException(String.join("\n", lowBalanceAccounts));
			} catch (MinBalanceException e) {
				System.out.println("\nException caught:\n" + e.getMessage());
			}
		}
	}
}
