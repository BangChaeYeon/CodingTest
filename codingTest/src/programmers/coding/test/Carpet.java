package programmers.coding.test;

import java.util.Arrays;

public class Carpet {
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		int sum = brown + yellow;
		
		for (int i = 3; i <= sum; i++) {
			int col = i;
			int row = sum / col;
			
			if (row < 3) continue;
			
			if (row >= col) {
				if ((row - 2) * (col - 2) == yellow) {
					answer[0] = row;
					answer[1] = col;
					break;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int brown1 = 10;
		int yellow1 = 2;
		
		System.out.println(Arrays.toString(solution(brown1, yellow1))); // [4, 3]
		
		// Test Case 02
		int brown2 = 8;
		int yellow2 = 1;
		
		System.out.println(Arrays.toString(solution(brown2, yellow2))); // 	[3, 3]
		
		// Test Case 03
		int brown3 = 24;
		int yellow3 = 24;
		
		System.out.println(Arrays.toString(solution(brown3, yellow3))); // [8, 6]
	}
}
