package programmers.coding.test;

import java.util.Arrays;

public class Immigration {
	
	public static long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = (long) n * times[times.length-1];
        long start = 1;
        long end = answer;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long pCnt = 0;
            
            for (int time : times) {
                pCnt += mid / time;
            }
            
            if (pCnt >= n) {
            	answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		
		System.out.println(solution(n, times)); // 28
	}
}
