package programmers.coding.school;

import java.util.Arrays;

public class ShareTShirts {
	
	public static int solution(int[] people, int[] tshirts) {
		int answer = 0;
		
		Arrays.sort(people);
		Arrays.sort(tshirts);
		
		for (int p : people) {
			for (int i = 0; i < tshirts.length; i++) {
				if (tshirts[i] != 0 && p <= tshirts[i]) {
					tshirts[i] = 0;
					answer += 1;
					break;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] people = {2, 3};
		int[] tshirts = {1, 2, 3};
		
		/*int[] people = {1, 1};
		int[] tshirts = {1, 2, 3};*/
		
		System.out.println(solution(people, tshirts));
	}

}
