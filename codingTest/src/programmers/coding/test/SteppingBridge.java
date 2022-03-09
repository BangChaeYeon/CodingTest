package programmers.coding.test;

import java.util.Arrays;

public class SteppingBridge {
	
	public static int binarySearch(int distance, int[] rocks, int n) {
		int result = 0;
		int start = 1;
		int end = distance;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int rmCnt = 0;
			int prev = 0;
			
			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - prev < mid) {
					rmCnt++;
				} else {
					prev = rocks[i];
				}
			}
			
			if (rmCnt > n) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = Math.max(result, mid);
			}
		}
		
		return result;
	}
	
	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		return binarySearch(distance, rocks, n);
	}
	
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		System.out.println(solution(distance, rocks, n)); // 4
	}
}
