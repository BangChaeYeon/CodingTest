package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2606 {
	
	public static int bfs(int[][] network, boolean[] validChk, int idx) {
		int cnt = -1; // 자기 자신 제외
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		
		while (!queue.isEmpty()) {
			int q = queue.poll();
			
			if (validChk[q]) continue;
			
			validChk[q] = true;
			cnt++;
			
			for (int i = 1; i < network.length; i++) {
				if (i != q && network[q][i] == 1) {
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine()) + 1;
			int m = Integer.parseInt(br.readLine());
			int[][] network = new int[n][n];
			boolean[] validChk = new boolean[n];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				
				network[row][col] = 1;
				network[col][row] = 1;
			}
			
			System.out.println(bfs(network, validChk, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
