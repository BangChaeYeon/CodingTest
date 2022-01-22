package programmers.coding.school;

import java.util.Arrays;

public class HashMap_After {
	
	public static int solution(String[][] clothes) {
		return Arrays.stream(clothes)
			.map(c -> c[1])
			.distinct()
			.map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
			.map(c -> c + 1)
			.reduce(1, (c, n) -> c * n) - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
	//	String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int result = solution(clothes);
		System.out.println(result);
	}

}
