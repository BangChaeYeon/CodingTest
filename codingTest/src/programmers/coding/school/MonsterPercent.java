package programmers.coding.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterPercent {
	
	public static int solution(int[] monster, int S1, int S2, int S3) {
		float answer = -1;
		
		List<Integer> list = new ArrayList<>();
		
		for (int s1 = 1; s1 <= S1; s1++) {
			for (int s2 = 1; s2 <= S2; s2++) {
				for (int s3 = 1; s3 <= S3; s3++) {
					int num = s1 + s2 + s3 + 1;
					list.add(num);
				}
			}
		}
		
		Arrays.sort(monster);
		
		int monsterCnt = 0;
		for (int l : list) {
			if (Arrays.binarySearch(monster, l) > -1) {
				monsterCnt += 1;
			}
		}
		
		answer = (float)(list.size() - monsterCnt) / list.size() * 1000;
		return (int) Math.floor(answer);
	}

	public static void main(String[] args) {
		int[] monster = {4,9,5,8};
		int s1 = 2;
		int s2 = 3;
		int s3 = 3;
		
		int result = solution(monster, s1, s2, s3);
		System.out.println(result);
	}

}
