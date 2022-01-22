package programmers.coding.school;

import java.util.Arrays;

public class Simulation_After {
	
	public static int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		int AIdx = 0;
		for (int i = 0; i < B.length; i++) {
			if (A[AIdx] < B[i]) {
				answer += 1;
				AIdx += 1;
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		
		int result = solution(A, B);
		System.out.println(result);
	}
}
