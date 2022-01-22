package programmers.coding.school;

import java.util.HashMap;

public class HashMap_Before {
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothesMap = new HashMap<>();
		
		// HashMap에 의상 정보 저장
		for (String[] c : clothes) {
			/*if (clothesMap.get(c[1]) == null) {
				clothesMap.put(c[1], 1);
			} else {
				clothesMap.put(c[1], (clothesMap.get(c[1]) + 1));
			}*/
			
			clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
		}
		
		// HashMap에 있는 각 의상 종류 별로 꺼내서 곱셈하여 조합 개수 구하기
		for (String key : clothesMap.keySet()) {
			// 의상을 입지 않는 경우를 포함하여 1을 더하기
			answer *= clothesMap.get(key) + 1;
		}
		
		// 의상을 입지 않았을 경우의 수 1빼기
		return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
	//	String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int result = solution(clothes);
		System.out.println(result);
	}

}
