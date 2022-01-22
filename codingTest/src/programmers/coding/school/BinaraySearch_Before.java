package programmers.coding.school;

import java.util.Arrays;

public class BinaraySearch_Before {
	
	public static int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets); // ���� �� �ִ� ���� ���ϱ� ���� ������
        
        int left = 1, mid;
        int right = budgets[budgets.length - 1]; // ���� �� ���� ū ���� �������� ���Ѿ��� ����
        
        while (left <= right) {
        	int cNum = 0;
        	mid = (left + right) / 2;
        	
        	// ���� ���� �߰� ���� ���Ѿ����� ����� ���� ������ ����
        	for (int b : budgets) {
        		if (b <= mid) cNum += b;
        		else cNum += mid;
        	}
        	
        	if (cNum == M) { // ������ �� ���꺸�� ���� ���� ������ �߰����� ���Ѿ��� ��
        		answer = mid;
        		break;
        	} else if (cNum < M) { // ������ �� ���꺸�� ���� ���� ���Ѿ��� ������ �߰� ������ ũ�ų� �����Ƿ� �߰� ���� ���� �������� �ٽ� Ž����
        		answer = mid;
        		left = mid + 1;
        	} else { // ������ �� ���꺸�� ���� ���� ���Ѿ��� ������ �߰� ������ �۾ƾ� �ϹǷ� �߰� ���� ���� �������� �ٽ� Ž����
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
