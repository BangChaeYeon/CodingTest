package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11399 {
	
	public static int getRequireTime(int[] atmTime) {
		int total = 0;
		
		for (int i = 1; i < atmTime.length; i++) {
			atmTime[i] += atmTime[i - 1];
		}
		
		for (int i = 0; i < atmTime.length; i++) {
			total += atmTime[i];
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] atmTime = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				atmTime[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(atmTime);
			
			System.out.println(getRequireTime(atmTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
