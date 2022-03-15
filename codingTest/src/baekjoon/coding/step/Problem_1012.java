package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1012 {
	static int[][] formula = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public static void dfs(int[][] map, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < formula.length; i++) {
			int fx = x + formula[i][0];
			int fy = y + formula[i][1];
			
			if (fx >= 0 && fx < map.length && fy >= 0 && fy < map[0].length) {
				if (!visited[fx][fy] && map[fx][fy] == 1) {
					dfs(map, visited, fx, fy);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringBuffer sb = new StringBuffer();
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				int[][] map = new int[m][n];
				boolean[][] visited = new boolean[m][n];
				
				for (int j = 0; j < k; j++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					map[x][y] = 1;
				}
				
				int count = 0;
				for (int x = 0; x < m; x++) {
					for (int y = 0; y < n; y++) {
						if (!visited[x][y] && map[x][y] == 1) {
							dfs(map, visited, x, y);
							count++;
						}
					}
				}
				
				sb.append(count).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
