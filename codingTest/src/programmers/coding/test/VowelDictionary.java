package programmers.coding.test;

public class VowelDictionary {
	
	public static boolean isFind;
	public static int answer;
	
	public static int solution(String word) {
		StringBuilder sb = new StringBuilder();
		String[] dic = {"A", "E", "I", "O", "U"};
		
		isFind = false;
		answer = 0;
		
		makeWord(dic, word, sb, 0);
		
		return answer;
	}
	
	public static void makeWord(String[] dic, String word, StringBuilder sb, int len) {
		if (sb.toString().equals(word)) {
			isFind = true;
			return;
		}
		else if (dic.length == len) return;
		
		for (int i = 0; i < dic.length; i++) {
			sb.append(dic[i]);
			answer++;
			makeWord(dic, word, sb, len + 1);
			if (isFind) return;
			sb.delete(sb.length() - 1, sb.length());
		}
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String word1 = "AAAAE";
		
		System.out.println(solution(word1)); // 6
		
		// Test Case 02
		String word2 = "AAAE";
		
		System.out.println(solution(word2)); // 10
		
		// Test Case 03
		String word3 = "I";
		
		System.out.println(solution(word3)); // 1563
		
		// Test Case 04
		String word4 = "EIO";
		
		System.out.println(solution(word4)); // 1189
	}

}
