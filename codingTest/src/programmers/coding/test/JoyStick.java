package programmers.coding.test;

public class JoyStick {
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		
		int idx = 0;
		int min = len - 1;
		
		for (int i = 0; i < len; i++) {
			char target = name.charAt(i);
			answer += Math.min(target - 'A', 'Z' - target + 1);
			
			idx = i + 1;
			while (idx < len && name.charAt(idx) == 'A') {
				idx++;
			}
			
			min = Math.min(min, i * 2 + len - idx);
			min = Math.min(min, (len - idx) * 2 + i);
		}
		
		return answer + min;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String name1 = "JEROEN";
		
		System.out.println(solution(name1)); // 56
		
		// Test Case 02
		String name2 = "JAN";
		
		System.out.println(solution(name2)); // 23
	}
	
}
