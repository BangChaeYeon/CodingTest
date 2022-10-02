package programmers.coding.test;

import java.util.Arrays;
import java.util.Stack;

public class DislikeSameNumber {
	
	public static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		for (int a : arr) {
			if (stack.peek() != a) {
				stack.push(a);
			}
		}
		
		return stack.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		// Test Case 01
		int[] arr1 = {1,1,3,3,0,1,1};
		
		System.out.println(Arrays.toString(solution(arr1))); // [1,3,0,1]
		
		// Test Case 02
		int[] arr2 = {4,4,4,3,3};
		
		System.out.println(Arrays.toString(solution(arr2))); // [4,3]
	}

}
