package programmers.coding.test;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	
	public static String solution(int[] numbers) {
		String[] sNumbers = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			sNumbers[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(sNumbers, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		if (sNumbers[0].startsWith("0")) return "0";
		else return String.join("", sNumbers);
	}

	public static void main(String[] args) {
		// Test Case 01
		int[] numbers1 = {6, 10, 2};
		
		System.out.println(solution(numbers1)); // 6210
		
		// Test Case 01
		int[] numbers2 = {3, 30, 34, 5, 9};
		
		System.out.println(solution(numbers2)); // 9534330
	}
}
