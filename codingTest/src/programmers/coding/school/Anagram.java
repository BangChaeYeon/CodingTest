package programmers.coding.school;

import java.util.Arrays;

public class Anagram {
	
	public static boolean solution(String a, String b) {
		boolean answer = false;
		
		if (a != null && b != null) {
			a = a.toLowerCase();
			b = b.toLowerCase();
			
			if (a.equals(b)) {
				answer = true;
			} else if (a.length() != b.length()) {
				answer = false;
			} else {
				String[] aStr = a.split("");
				String[] bStr = b.split("");
				
				Arrays.sort(aStr);
				Arrays.sort(bStr);
				
				if (String.join("", aStr).equals(String.join("", bStr))) {
					answer = true;
				}
			}
		} else if (a == null && b == null) {
			answer = true;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		/*String a = "listen";
		String b = "silent";*/
		
		String a = "anagram";
		String b = "MARGANA";
		
		System.out.println(solution(a, b));
	}

}
