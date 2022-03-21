package programmers.coding.test;

import java.util.Arrays;

public class GymClothes {
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		int idx = 0;
		
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					reserve[i] = -1;
					lost[j] = -1;
					answer++;
					idx++;
					break;
				}
			}
		}
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		for (int i = idx; i < reserve.length; i++) {
			for (int j = idx; j < lost.length; j++) {
				if (lost[j] != -1 && (reserve[i] + 1 == lost[j] || reserve[i] - 1 == lost[j])) {
					lost[j] = -1;
					answer++;
					break;
				}
			}
			
			if (answer == n) break;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int n1 = 5;
		int[] lost1 = {2, 4};
		int[] reserve1 = {1, 3, 5};
		
		System.out.println(solution(n1, lost1, reserve1)); // 5
		
		// Test Case 02
		int n2 = 5;
		int[] lost2 = {2, 4};
		int[] reserve2 = {3};
		
		System.out.println(solution(n2, lost2, reserve2)); // 4
		
		// Test Case 03
		int n3 = 3;
		int[] lost3 = {3};
		int[] reserve3 = {1};
		
		System.out.println(solution(n3, lost3, reserve3)); // 2
		
		// Test Case 04
		int n4 = 5;
		int[] lost4 = {2, 3};
		int[] reserve4 = {2, 5};
		
		System.out.println(solution(n4, lost4, reserve4)); // 4
		
		// Test Case 05
		int n5 = 10;
		int[] lost5 = {3, 6, 7};
		int[] reserve5 = {2, 7, 8};
		
		System.out.println(solution(n5, lost5, reserve5)); // 9
	}
	
}
