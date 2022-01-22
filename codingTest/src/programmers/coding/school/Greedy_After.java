package programmers.coding.school;

import java.util.Arrays;

public class Greedy_After {
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0; // 기지국 설치 개수
		int sIdx = 0; // stations의 인덱스
		int position = 1; // 현재 탐색 위치
		
		// 모든 아파트를 담색할 때까지 반복
		while(position <= n){
			if (sIdx < stations.length && stations[sIdx] - w <= position) { // 현재 위치가 전파 범위 안에 있을 때
				position += w + 1; // 위치를 범위 바깥으로 이동
				sIdx += 1; // 다음 기지국이 설치된 아파트 탐색
			} else { // 현재 위치가 전파 범위 밖에 있을 때
				answer += 1; // 기지국을 설치하고
				position += (w * 2) + 1; // 위치를 범위 바깥으로 이동
			}
		}
		
		return answer;
	}
	
	/**
	 * n: 아파트의 개수(200,000,000 이하의 자연수)
	 * stations: 기지국이 설치된 아파트의 번호가 담긴 배열(크기 - 10,000 이하의 자연수)
	 * w: 전파의 도달거리(10,000 이하의 자연수)
	 */
	public static void main(String[] args) {
		/*int n = 21;
		int[] stations = {};
		int w = 2;
		int answer = solution(n, stations, w);*/
		
		
		int n = 16;
		int[] stations = {9};
		int w = 2;
		int answer = solution(n, stations, w);
		
		System.out.println(answer);
	}

}
