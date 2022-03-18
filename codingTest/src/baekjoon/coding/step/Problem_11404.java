package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11404 {
	
	public static void print(int[][] list) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if(list[i][j] >= 10000000) sb.append("0 ");
				else sb.append(list[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			StringTokenizer st = null;
			int[][] list = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) list[i][j] = 10000000;
				}
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				
				list[start][end] = Math.min(list[start][end], cost);
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						list[i][j] = Math.min(list[i][j], list[i][k] + list[k][j]);
					}
				}
			}
			
			print(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
