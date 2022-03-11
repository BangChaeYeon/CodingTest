package programmers.coding.test;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<>();
		
		for (String[] cloth : clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}
		
		for (String key : map.keySet()) {
			answer *= (map.get(key) + 1);
		}
		
		return answer - 1;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(clothes1)); // 5
		
		// Test Case 02
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		
		System.out.println(solution(clothes2)); // 3
	}
}
