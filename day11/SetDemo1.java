package com.day11;

import java.util.HashSet;
import java.util.Set;

public class SetDemo1 {

	public static void main(String[] args) {
		Set<String> interest = new HashSet<String>();
		interest.add("Reading");
		interest.add("Playing");
		interest.add("Cooking");
		
		System.out.println(interest.add("hu"));

	}
}
