package programmers.coding.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightBracket {
	
	public static String[] solution(int N) {
		List<String> list = new ArrayList<>();
		char[] charArr = new char[N * 2];
		charArr[0] = '(';
		charArr[(charArr.length - 1)] = ')';
		
		int idx = 1;
		int len = N * 2 - 2;
		
		while (idx <= len) {
			char[] c1 = charArr.clone();
			char[] c2 = charArr.clone();
			
			for (int i = idx; i < len; i++) {
				c1[i] = '(';
				c2[i] = ')';
			}
			
			for (int i = len; i > idx; i--) {
				c1[i] = ')';
				c2[i] = '(';
			}
			
			idx += 1;
			
			list.add(new String(c1));
			list.add(new String(c2));
		}
		
		
		String[] answer = list.toArray(new String[0]);
		
		Arrays.sort(answer);
		
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 2;
		
		System.out.println(Arrays.toString(solution(N)));
	}

}
