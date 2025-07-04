package assignment.callJava8Assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CallRecordAnalyzer {

	private static final Scanner scanner = new Scanner(System.in);
	private static final List<CallRecord> records = new ArrayList<>();

	public static void main(String[] args) {
		boolean exit = false;
		while (!exit) {
			printMenu();
			int choice = readInt("Choose an option: ");
			switch (choice) {
			case 1:
				addCallRecord();
				break;
			case 2:
				showLongestCalls();
				break;
			case 3:
				showFrequentCallers();
				break;
			case 4:
				groupByOperator();
				break;
			case 5:
				groupByLocation();
				break;
			case 6:
				filterByDuration();
				break;
			case 0:
				System.out.println("Exiting...");
				exit = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}

		}

	}

	private static void printMenu() {
		System.out.println("\n--- Telecom Customer Call Records Analyzer ---");
		System.out.println("1. Add Call Record");
		System.out.println("2. Show Top 5 Longest Calls");
		System.out.println("3. Show Top 5 Frequent Callers");
		System.out.println("4. Group Calls by Operator");
		System.out.println("5. Group Calls by Location");
		System.out.println("6. Filter Calls by Minimum Duration");
		System.out.println("0. Exit");
	}

	private static void addCallRecord() {
		System.out.println("Enter call details:");
		String caller = readString("Caller Number: ");
		String receiver = readString("Receiver Number: ");
		LocalDateTime startTime = readDateTime("Start Time (yyyy-MM-dd HH:mm): ");
		int duration = readInt("Duration (seconds): ");
		String operator = readString("Operator: ");
		String location = readString("Location: ");

		CallRecord record = new CallRecord(caller, receiver, startTime, duration, operator, location);
		records.add(record);
		System.out.println("Call record added.");
	}

	private static void showLongestCalls() {
		System.out.println("--- Top 5 Longest Calls ---");
		records.stream().sorted(Comparator.comparingInt(CallRecord::getDurationSeconds).reversed()).limit(5)
				.forEach(System.out::println);
	}

	private static void showFrequentCallers() {
		System.out.println("--- Top 5 Frequent Callers ---");
		Map<String, Long> callerCount = records.stream()
				.collect(Collectors.groupingBy(CallRecord::getCallerNumber, Collectors.counting()));

		callerCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5)
				.forEach(e -> System.out.printf("Caller: %s, Calls: %d%n", e.getKey(), e.getValue()));
	}

	private static void groupByOperator() {
		System.out.println("--- Calls Grouped by Operator ---");
		Map<String, List<CallRecord>> grouped = records.stream()
				.collect(Collectors.groupingBy(CallRecord::getOperator));

		grouped.forEach((operator, calls) -> {
			System.out.printf("Operator: %s (%d calls)%n", operator, calls.size());
			calls.forEach(call -> System.out.println("  " + call));
		});
	}

	private static void groupByLocation() {
		System.out.println("--- Calls Grouped by Location ---");
		Map<String, List<CallRecord>> grouped = records.stream()
				.collect(Collectors.groupingBy(CallRecord::getLocation));

		grouped.forEach((location, calls) -> {
			System.out.printf("Location: %s (%d calls)%n", location, calls.size());
			calls.forEach(call -> System.out.println("  " + call));
		});
	}

	private static void filterByDuration() {
		int minDuration = readInt("Enter minimum duration (seconds): ");
		System.out.printf("--- Calls with duration >= %d seconds ---\n", minDuration);
		records.stream().filter(r -> r.getDurationSeconds() >= minDuration).forEach(System.out::println);
	}

	private static int readInt(String prompt) {
		System.out.print(prompt);
		while (!scanner.hasNextInt()) {
			System.out.print("Please enter a valid integer: ");
			scanner.next();
		}
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}

	private static String readString(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	private static LocalDateTime readDateTime(String prompt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine();
			try {
				return LocalDateTime.parse(input, formatter);
			} catch (Exception e) {
				System.out.println("Invalid date/time format. Please use yyyy-MM-dd HH:mm");
			}
		}
	}
}
