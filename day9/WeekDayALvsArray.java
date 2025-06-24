package com.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekDayALvsArray {
	public static void main(String[] args) {

		String weekDays[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		List<String> weekAl = new ArrayList<String>(
				List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));

//		List<String> weekAl = new ArrayList<>();
//		weekAl.addAll("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		
		System.out.println(weekDays.toString());
		System.out.println(weekAl);
		
		
		Arrays.sort(weekDays);
	}

}
