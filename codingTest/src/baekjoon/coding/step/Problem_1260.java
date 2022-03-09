package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1260 {
	
	public static void dfs(int[][] node, boolean[] chk, int idx, StringBuilder sb) {
		if (chk[idx]) return;
		
		sb.append(idx).append(" ");
		
		for (int i = 1; i < node.length; i++) {
			if (i != idx && node[idx][i] == 1) {
				chk[idx] = true;
				dfs(node, chk, i, sb);
			}
		}
	}
	
	public static void bfs(int[][] node, boolean[] chk, int idx, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		
		while (!queue.isEmpty()) {
			int q = queue.poll();
			
			if (chk[q]) continue; // break 사용 시 탐색이 중단되는 경우가 있어서 continue 사용함
			
			sb.append(q).append(" ");
			chk[q] = true;
			
			for (int i = 1; i < node.length; i++) {
				if (i != q && node[q][i] == 1) {
					queue.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()) + 1; // 직관적으로 위치를 표시하기 위해 +1 함
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			boolean[] chk = new boolean[n];
			int[][] node = new int[n][n];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				
				node[row][col] = 1;
				node[col][row] = 1;
			}
			
			StringBuilder dfsSb = new StringBuilder();
			StringBuilder bfsSb = new StringBuilder();
			
			dfs(node, chk, v, dfsSb);
			
			Arrays.fill(chk, false); // 체크용 boolean 배열 다시 false로 초기화
			
			bfs(node, chk, v, bfsSb);
			
			System.out.println(dfsSb.toString().trim());
			
			System.out.println(bfsSb.toString().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
