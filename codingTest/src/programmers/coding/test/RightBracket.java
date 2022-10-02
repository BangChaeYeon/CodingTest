package programmers.coding.test;

import java.util.Stack;

public class RightBracket {
	
	static boolean solution(String s) {
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			
			if (str.equals("(")) {
				stack.push(str);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// Test Case 01
		String s1 = "()()";
		
		System.out.println(solution(s1)); // true
		
		// Test Case 02
		String s2 = "(())()";
		
		System.out.println(solution(s2)); // true
		
		// Test Case 03
		String s3 = ")()(";
		
		System.out.println(solution(s3)); // false
		
		// Test Case 04
		String s4 = "(()(";
		
		System.out.println(solution(s4)); // false
	}

}
