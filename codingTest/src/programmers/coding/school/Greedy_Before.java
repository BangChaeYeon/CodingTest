package programmers.coding.school;

import java.util.Arrays;

public class Greedy_Before {
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		boolean[] delivery = new boolean[n];
		
		// 전파가 전달되는 범위 체크
		for (int s : stations) {
			for (int i = (s - w - 1) > 0 ? (s - w - 1) : 0; i < ((s + w) < n ? (s + w) : n); i++) {
				delivery[i] = true;
			} 
		}
		
		System.out.println(Arrays.toString(delivery));
		
		// 기지국 추가
		for (int i = 0; i < delivery.length; i++) {
			// 현재 아파트에 전파가 전달되지 않을 때
			if (!delivery[i]) {
				int s1 = (i - w) > 0 ? (i - w) : 0; // 현재 위치에서 범위 만큼을 뺀 최소 위치
				int s2 = (i + w + 1) < n ? (i + w + 1) : n; // 현재 위치에서 범위 만큼을 더한 최대 위치
				int j = s1, limit = s2;
				
				if (!delivery[s1]) { // 현재 위치 기준으로 최소 범위에도 전파가 전달되지 않을 때
					j = (s1 - w) > 0 ? (s1 - w) : 0;
					limit = (s1 + w + 1) < n ? (s1 + w + 1) : n;
				} else if (!delivery[(s2 - 1)]) { // 현재 위치 기준으로 최대 범위에도 전파가 전달되지 않을 때
					j = ((s2 - 1) - w) > 0 ? ((s2 - 1) - w) : 0;
					limit = ((s2 - 1) + w + 1) < n ? ((s2 - 1) + w + 1) : n;
				}
				
				// 범위 내의 아파트 전달 체크
				for (; j < limit; j++) {
					delivery[j] = true;
				}
				
				answer++;
			}
		}
		
		System.out.println(Arrays.toString(delivery));
		
		return answer;
	}
	
	
	/**
	 * n: 아파트의 개수(200,000,000 이하의 자연수)
	 * stations: 기지국이 설치된 아파트의 번호가 담긴 배열(크기 - 10,000 이하의 자연수)
	 * w: 전파의 도달거리(10,000 이하의 자연수)
	 */
	public static void main(String[] args) {
		/*int n = 11;
		int[] stations = {4, 11};
		int w = 1;
		int answer = solution(n, stations, w);*/
		
		int n = 16;
		int[] stations = {9};
		int w = 2;
		int answer = solution(n, stations, w);
		
		System.out.println(answer);
	}

}
