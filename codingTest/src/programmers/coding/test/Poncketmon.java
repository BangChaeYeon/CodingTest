package programmers.coding.test;

import java.util.HashMap;
import java.util.Map;

public class Poncketmon {
	
	public static int solution(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int answer = nums.length / 2;
		
		if (map.size() < answer) answer = map.size();
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int[] nums1 = {3,1,2,3};
		
		System.out.println(solution(nums1)); // 2
		
		// Test Case 02
		int[] nums2 = {3,3,3,2,2,4};
		
		System.out.println(solution(nums2)); // 3
		
		// Test Case 03
		int[] nums3 = {3,3,3,2,2,2};
		
		System.out.println(solution(nums3)); // 2
	}

}
