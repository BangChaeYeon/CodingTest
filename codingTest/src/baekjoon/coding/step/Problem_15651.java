package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15651 {
	static StringBuilder sb = new StringBuilder();
	static int[] nArr;
	
	public static void getNumProgress(int n, int m, int idx) {
		if (m == idx) {
			for (int num : nArr) {
				sb.append(num).append(" ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			nArr[idx] = i + 1;
			getNumProgress(n, m, idx + 1);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			nArr = new int[m];
			
			getNumProgress(n, m, 0);
			
			System.out.println(sb.toString().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
