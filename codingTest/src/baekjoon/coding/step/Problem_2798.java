package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_2798 {
	static int cardNums[];
	
	public static int search(int cardNums[], int tNum) {
		int result = 0;
		
		for(int i = 0; i < cardNums.length; i++){
			for(int j = (i + 1); j < cardNums.length; j++){
				for(int k = (j + 1); k < cardNums.length; k++){
					int sum = cardNums[i] + cardNums[j] + cardNums[k];
					
					if(sum > result && sum <= tNum){
						result = sum;
					}
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String a1[] = br.readLine().split(" ");
			String a2[] = br.readLine().split(" ");
			
			int qCnt = Integer.parseInt(a1[0]);
			int tNum = Integer.parseInt(a1[1]);
			cardNums = new int[qCnt];
			
			for (int i = 0; i < qCnt; i++) {
				if(Integer.parseInt(a2[i]) < tNum)
					cardNums[i] = Integer.parseInt(a2[i]);
			}
			
			int result = search(cardNums, tNum);
			System.out.println(result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
