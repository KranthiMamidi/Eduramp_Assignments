package com.day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapExamples {
	public static void main(String[] args) {

		Map<Integer, String> one = new HashMap<>();
		one.put(1, "Kranthi");
		one.put(2, "Kumar");

		System.out.println(one);

		for (Map.Entry<Integer, String> entry : one.entrySet()) {
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}
		System.out.println("------");
		System.out.println(one.get(1));
		System.out.println(one.containsKey(1));
		System.out.println(one.containsValue("Kranthi"));
		System.out.println(one.size());

		Map<Integer, int[]> customer = new HashMap<Integer, int[]>();
		int[] innn = { 1, 2, 3 };
		customer.put(1, innn);
		System.out.println();
		System.out.println(customer);

		Map<Integer, List<String>> map = new HashMap<>();
		List<String> liist = Arrays.asList("Kranthi", "Kumar");

		map.put(101, liist);
		map.put(102, Arrays.asList("Sravan", "Anand"));

		System.out.println(map);
		System.out.println("-------------------------");
		System.out.println(map.containsValue(liist));
		System.out.println(map.containsKey(Arrays.asList("Kranthi", "Kumar")));
		for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " == " + entry.getValue());
		}

	}

}
