package programmers.coding.school;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_After {
	
	public static String solution(int[] numbers) {
		String[] sArr = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			sArr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(sArr, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		if(sArr[0].equals("0")) return "0";
		return String.join("", sArr);
	}
	
	public static void main(String[] args) {
		int numbers[] = {0, 0, 0, 0, 0};
		String solution = solution(numbers);
		
		System.out.println(solution);
	}

}
