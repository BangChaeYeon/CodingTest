package programmers.coding.school;

import java.util.Arrays;

public class Greedy_Before {
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		boolean[] delivery = new boolean[n];
		
		// ���İ� ���޵Ǵ� ���� üũ
		for (int s : stations) {
			for (int i = (s - w - 1) > 0 ? (s - w - 1) : 0; i < ((s + w) < n ? (s + w) : n); i++) {
				delivery[i] = true;
			} 
		}
		
		System.out.println(Arrays.toString(delivery));
		
		// ������ �߰�
		for (int i = 0; i < delivery.length; i++) {
			// ���� ����Ʈ�� ���İ� ���޵��� ���� ��
			if (!delivery[i]) {
				int s1 = (i - w) > 0 ? (i - w) : 0; // ���� ��ġ���� ���� ��ŭ�� �� �ּ� ��ġ
				int s2 = (i + w + 1) < n ? (i + w + 1) : n; // ���� ��ġ���� ���� ��ŭ�� ���� �ִ� ��ġ
				int j = s1, limit = s2;
				
				if (!delivery[s1]) { // ���� ��ġ �������� �ּ� �������� ���İ� ���޵��� ���� ��
					j = (s1 - w) > 0 ? (s1 - w) : 0;
					limit = (s1 + w + 1) < n ? (s1 + w + 1) : n;
				} else if (!delivery[(s2 - 1)]) { // ���� ��ġ �������� �ִ� �������� ���İ� ���޵��� ���� ��
					j = ((s2 - 1) - w) > 0 ? ((s2 - 1) - w) : 0;
					limit = ((s2 - 1) + w + 1) < n ? ((s2 - 1) + w + 1) : n;
				}
				
				// ���� ���� ����Ʈ ���� üũ
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
	 * n: ����Ʈ�� ����(200,000,000 ������ �ڿ���)
	 * stations: �������� ��ġ�� ����Ʈ�� ��ȣ�� ��� �迭(ũ�� - 10,000 ������ �ڿ���)
	 * w: ������ ���ްŸ�(10,000 ������ �ڿ���)
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
