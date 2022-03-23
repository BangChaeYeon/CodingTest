package programmers.coding.test;

public class MakeBigNumber {
	
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		
		int idx = 0;
		char max = '0';
		
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';
			
			for (int j = idx; j <= k + i; j++) {
				if (number.charAt(j) > max) {
					max = number.charAt(j);
					idx  = j + 1;
				}
			}
			
			sb.append(max);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String number1 = "1924";
		int k1 = 2;
		
		System.out.println(solution(number1, k1)); // 94
		
		// Test Case 02
		String number2 = "1231234";
		int k2 = 3;
		
		System.out.println(solution(number2, k2)); // 3234
		
		// Test Case 03
		String number3 = "4177252841";
		int k3 = 4;
		
		System.out.println(solution(number3, k3)); // 775841
		
	}
	
}
