package programmers.coding.test;

import java.util.Arrays;

public class NumberK {
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int idx = 0; idx < commands.length; idx++) {
			int i = commands[idx][0] - 1;
			int j = commands[idx][1];
			int k = commands[idx][2] - 1;
			
			int[] arr = Arrays.copyOfRange(array, i, j);
			Arrays.sort(arr);
			
			answer[idx] = arr[k];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(solution(array, commands))); // [5, 6, 3]
	}
}
