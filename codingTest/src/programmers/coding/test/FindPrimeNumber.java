package programmers.coding.test;

import java.util.ArrayList;

public class FindPrimeNumber {
	static ArrayList<Integer> numberList;
	
	public static void makeNumber(String[] numStrArr, boolean[] valid, int idx, String temp) {
		if (idx == temp.length()) {
			int number = Integer.parseInt(temp);
			
			if (!numberList.contains(number) && number != 0 && number != 1) {
				numberList.add(number);
			}
			
			return;
		} else {
			for (int i = 0; i < numStrArr.length; i++) {
				if (!valid[i]) {
					valid[i] = true;
					temp += numStrArr[i];
					makeNumber(numStrArr, valid, idx, temp);
					valid[i] = false;
					temp = temp.substring(0, temp.length() - 1);
				}
			}
		}
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		String[] numStrArr = numbers.split("");
		boolean[] valid = new boolean[numStrArr.length];
		numberList = new ArrayList<>();
		
		for (int i = 1; i <= numStrArr.length; i++) {
			makeNumber(numStrArr, valid, i, "");
		}
		
		for (int i = 0; i < numberList.size(); i++) {
			int number = numberList.get(i);
			boolean isPrime = true;
			
			for (int j = 2; j < number; j++) {
				if (number % j == 0) isPrime = false;
			}
			
			if (isPrime) answer++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// Test Case 01
		String numbers1 = "17";
		
		System.out.println(solution(numbers1)); // 3
		
		// Test Case 02
		String numbers2 = "011";
		
		System.out.println(solution(numbers2)); // 2
	}
}
