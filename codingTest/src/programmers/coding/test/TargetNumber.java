package programmers.coding.test;

public class TargetNumber {
	static int answer = 0;
	
	public static void makeTargetNumber(int[] numbers, int target, int idx, int sum) {
		if (idx == numbers.length) {
			if (sum == target) {
				answer++;
			}
			
			return;
		}
		
		makeTargetNumber(numbers, target, idx + 1, sum + numbers[idx]);
		makeTargetNumber(numbers, target, idx + 1, sum - numbers[idx]);
	}
	
	public static int solution(int[] numbers, int target) {
		answer = 0;
		makeTargetNumber(numbers, target, 0, 0);
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int[] numbers1 = {1, 1, 1, 1, 1};
		int target1 = 3;
		
		System.out.println(solution(numbers1, target1)); // 5
		
		// Test Case 02
		int[] numbers2 = {4, 1, 2, 1};
		int target2 = 4;
		
		System.out.println(solution(numbers2, target2)); // 2
	}
}
