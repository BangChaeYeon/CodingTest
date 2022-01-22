package programmers.coding.school;

import java.util.HashMap;

public class HashMap_Before {
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothesMap = new HashMap<>();
		
		// HashMap�� �ǻ� ���� ����
		for (String[] c : clothes) {
			/*if (clothesMap.get(c[1]) == null) {
				clothesMap.put(c[1], 1);
			} else {
				clothesMap.put(c[1], (clothesMap.get(c[1]) + 1));
			}*/
			
			clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
		}
		
		// HashMap�� �ִ� �� �ǻ� ���� ���� ������ �����Ͽ� ���� ���� ���ϱ�
		for (String key : clothesMap.keySet()) {
			// �ǻ��� ���� �ʴ� ��츦 �����Ͽ� 1�� ���ϱ�
			answer *= clothesMap.get(key) + 1;
		}
		
		// �ǻ��� ���� �ʾ��� ����� �� 1����
		return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
	//	String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int result = solution(clothes);
		System.out.println(result);
	}

}
