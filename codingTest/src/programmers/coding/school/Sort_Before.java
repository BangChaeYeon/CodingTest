package programmers.coding.school;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_Before {
	
	public static class NumberOrder implements Comparator<Integer> {
		@Override
		public int compare(Integer s1, Integer s2) {
			// 비교하려는 두 수의 자릿수 구하기
			int n1 = (int)(Math.log10(s1) + 1);
			int n2 = (int)(Math.log10(s2) + 1);
			
			// 두 수의 자릿수 맞추기
			if (n1 > n2) {
				s2 = s2 * (int) Math.pow(10, (n1 - n2));
			} else if (n1 < n2) {
				s1 = s1 * (int) Math.pow(10, (n2 - n1));
			}
			
			// 내림차순으로 정렬
			return (s1 < s2) ? 1 : (s1 > s2) ? -1 : 0;
		}
	}
	
	public static String solution(int[] numbers) {
		StringBuffer answer = new StringBuffer();
		Integer numberArr[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		
		System.out.println(Arrays.toString(numbers));
		
		Arrays.sort(numberArr);
		Arrays.sort(numberArr, new NumberOrder());
		
		System.out.println(Arrays.toString(numberArr));
		
		for (Integer num : numberArr) {
			answer.append(num);
		}
		
		return answer.toString();
    }
	
	// numbers: 0 이상의 정수가 들어있는 배열
	public static void main(String[] args) {
		int numbers[] = {100, 10, 1, 0, 0, 02, 20};
		String result = solution(numbers);
		
		System.out.println(result);
	}

}
