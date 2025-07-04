package classAssignment4_7_25;

import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
//		System.out.println("hello");
		Map<String, Customer> customers = new HashMap<>();
		Map<String, List<CallLog>> callLogs = new HashMap<>();

		BillingEngine engine = BillingEngine.getInstance();
		engine.addObserver(new SMSNotifier());

		// Register Customers
		Customer kranthi = new Customer("Kranthi", "001");
		Customer manoj = new Customer("Manoj", "002");
		kranthi.activatePlan("Prepaid");
		manoj.activatePlan("Postpaid");
		customers.put(kranthi.phone, kranthi);
		customers.put(manoj.phone, manoj);

		// Simulate calls
		CallLog log1 = new CallLog(kranthi.phone, manoj.phone, 2);
		CallLog log2 = new CallLog(manoj.phone, kranthi.phone, 3);
		callLogs.computeIfAbsent(kranthi.phone, k -> new ArrayList<>()).add(log1);
		callLogs.computeIfAbsent(manoj.phone, k -> new ArrayList<>()).add(log2);

		// Print Logs
		System.out.println("===== Call Logs =====");
		for (var entry : callLogs.entrySet()) {
			Customer c = customers.get(entry.getKey());
			System.out.println("Logs for: " + c);
			for (CallLog log : entry.getValue()) {
				System.out.println("  " + log);
			}
		}

		// Generate Bills
		System.out.println("\n===== Bills =====");
		for (var entry : callLogs.entrySet()) {
			Customer c = customers.get(entry.getKey());
			engine.generateBill(c, entry.getValue());
		}
	}
}
