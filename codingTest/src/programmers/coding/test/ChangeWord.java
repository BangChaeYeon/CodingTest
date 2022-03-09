package programmers.coding.test;

public class ChangeWord {
	
	static int result = 50;
	
	public static void dfs(String[] words, boolean[] valid, String word, String target, int cnt) {
		if (word.equals(target)) {
			result = Math.min(result, cnt);
			return;
		}
		
		for (int i = 0 ; i < words.length; i++) {
			if (valid[i]) continue;
			int sCnt = 0;

			for (int j = 0; j < word.length(); j++) {
				if (words[i].charAt(j) == word.charAt(j)) sCnt++;
			}
			
			if (sCnt == word.length() - 1) {
				valid[i] = true;
				result++;
				dfs(words, valid, words[i], target, cnt + 1);
				valid[i] = false;
			}
		}
	}
	
	public static int solution(String begin, String target, String[] words) {
		boolean[] valid = new boolean[words.length];
		boolean chk = false;
		result = 50;
		
		for (String word : words) {
			if (word.equals(target)) {
				chk = true;
				break;
			}
		}
		
		if (chk) dfs(words, valid, begin, target, 0);
		else return 0;
		
		return result;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String begin1 = "hit";
		String target1 = "cog";
		String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin1, target1, words1)); // 4
		
		// Test Case 02
		String begin2 = "hit";
		String target2 = "cog";
		String[] words2 = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(solution(begin2, target2, words2)); // 0
	}
}
