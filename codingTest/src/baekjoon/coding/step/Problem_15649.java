package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_15649 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] chk;
	static int[] arr;
	
	private static void getNumProgress(int n, int m, int idx) {
		if (m <= idx) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!chk[i]) {
				chk[i] = true;
				arr[idx] = i + 1;
				getNumProgress(n, m, idx + 1);
				
				chk[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			chk = new boolean[n];
			arr = new int[m];
			
			getNumProgress(n, m, 0);
			System.out.println(sb.toString().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
