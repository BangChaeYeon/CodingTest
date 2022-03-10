package programmers.coding.test;

import java.util.Arrays;

public class H_Index {
	
	public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		for (int i = 0; i <  citations.length; i++) {
			int cnt = citations.length - i;
			
			if (citations[i] >= cnt) {
				answer = cnt;
				break;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(solution(citations)); // 3
	}
}
