package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_1003 {
	
	static int[] fArr;
	static int zeroCnt = 0;
	static int oneCnt = 0;
	
	public static void fibonacci(int n) {
		if (n < 0) return;
		
		if (n == 0) {
			zeroCnt++;
		} else if (n == 1) {
			oneCnt++;
		} else {
			int zero = 1;
			int one = 0;
			int sum = 1;
			
			for (int i = 0; i < n; i++) {
				zero = one;
				one = sum;
				sum = zero + one;
			}
			
			zeroCnt += zero;
			oneCnt += one;
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				fArr = new int[n + 1];
				zeroCnt = oneCnt = 0;
				fibonacci(n);
				sb.append(zeroCnt + " " + oneCnt).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
