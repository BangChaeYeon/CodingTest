package programmers.coding.school;

import java.util.Arrays;

public class BinaraySearch_Before {
	
	public static int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets); // 예산 중 최대 값을 구하기 위해 정렬함
        
        int left = 1, mid;
        int right = budgets[budgets.length - 1]; // 예산 중 가장 큰 값을 기준으로 상한액을 구함
        
        while (left <= right) {
        	int cNum = 0;
        	mid = (left + right) / 2;
        	
        	// 범위 내의 중간 값을 상한액으로 잡았을 때의 총합을 구함
        	for (int b : budgets) {
        		if (b <= mid) cNum += b;
        		else cNum += mid;
        	}
        	
        	if (cNum == M) { // 총합이 총 예산보다 같을 때는 현재의 중간값이 상한액이 됨
        		answer = mid;
        		break;
        	} else if (cNum < M) { // 총합이 총 예산보다 작을 때는 상한액이 현재의 중간 값보다 크거나 같으므로 중간 기준 우측 범위에서 다시 탐색함
        		answer = mid;
        		left = mid + 1;
        	} else { // 총합이 총 예산보다 많을 때는 상한액이 현재의 중간 값보다 작아야 하므로 중간 기준 좌측 범위에서 다시 탐색함
        		right = mid - 1;
        	}; 
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		
		int result = solution(budgets, M);
		System.out.println(result);
	}

}
