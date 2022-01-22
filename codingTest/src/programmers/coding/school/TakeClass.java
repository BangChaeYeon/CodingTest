package programmers.coding.school;

import java.util.Arrays;

public class TakeClass {
	
	public static String[] solution(String[] s1, String[] s2, String k) {
		String[] answer = {};
		
		return answer;
	}
	
	public static void main(String[] args) {
		String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
		String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
		String k = "B";
		// result = ["D", "H", "E", "C", "F", "B"]
		
		/*
			String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
			String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
			String k = "G";
			// result = ["A", "D", "H", "E", "C", "F", "B", "G"]
		*/
		System.out.println(Arrays.toString(solution(s1, s2, k)));
	}

}
