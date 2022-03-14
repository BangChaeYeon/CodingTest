package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_11047 {
	
	public static int getCoinCount(Integer[] coins, int total) {
		int count = 0;
		int temp = total;
		
		for (int i = 0; i < coins.length; i++) {
			count += temp / (int) coins[i];
			
			if (count > 0) {
				temp = temp % (int) coins[i];
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Integer[] coins = new Integer[n];
			
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(coins, Collections.reverseOrder());
			
			System.out.println(getCoinCount(coins, k));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
