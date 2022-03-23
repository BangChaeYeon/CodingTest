package programmers.coding.test;

import java.util.Arrays;

public class LifeBoat {
	
	public static int solution(int[] people, int limit) {
		int answer = people.length;
		
		Arrays.sort(people);
		
		int i = 0;
		int j = people.length - 1;
		while (i < j) {
			if (people[i] + people[j] <= limit) {
				answer--;
				people[j] = limit;
				i++;
			}
			
			j--;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int[] people1 = {70, 50, 80, 50};
		int limit1 = 100;
		
		System.out.println(solution(people1, limit1)); // 3
		
		// Test Case 02
		int[] people2 = {70, 80, 50};
		int limit2 = 100;
		
		System.out.println(solution(people2, limit2)); // 3
	}
	
}
