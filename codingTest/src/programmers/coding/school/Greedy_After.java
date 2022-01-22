package programmers.coding.school;

import java.util.Arrays;

public class Greedy_After {
	
	public static int solution(int n, int[] stations, int w) {
		int answer = 0; // ������ ��ġ ����
		int sIdx = 0; // stations�� �ε���
		int position = 1; // ���� Ž�� ��ġ
		
		// ��� ����Ʈ�� ����� ������ �ݺ�
		while(position <= n){
			if (sIdx < stations.length && stations[sIdx] - w <= position) { // ���� ��ġ�� ���� ���� �ȿ� ���� ��
				position += w + 1; // ��ġ�� ���� �ٱ����� �̵�
				sIdx += 1; // ���� �������� ��ġ�� ����Ʈ Ž��
			} else { // ���� ��ġ�� ���� ���� �ۿ� ���� ��
				answer += 1; // �������� ��ġ�ϰ�
				position += (w * 2) + 1; // ��ġ�� ���� �ٱ����� �̵�
			}
		}
		
		return answer;
	}
	
	/**
	 * n: ����Ʈ�� ����(200,000,000 ������ �ڿ���)
	 * stations: �������� ��ġ�� ����Ʈ�� ��ȣ�� ��� �迭(ũ�� - 10,000 ������ �ڿ���)
	 * w: ������ ���ްŸ�(10,000 ������ �ڿ���)
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
