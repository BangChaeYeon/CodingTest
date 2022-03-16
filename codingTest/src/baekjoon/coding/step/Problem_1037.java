package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1037 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 1) {
				int factor = Integer.parseInt(br.readLine());
				
				System.out.println(factor * factor);
			} else {
				int[] factor = new int[n];
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < factor.length; i++) {
					factor[i] = Integer.parseInt(st.nextToken());
				}
				
				Arrays.sort(factor);
				
				System.out.println(factor[0] * factor[factor.length - 1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
