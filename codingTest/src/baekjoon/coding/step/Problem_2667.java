package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Problem_2667 {
	
	public static int bfs(int[][] map, boolean[][] visited, int i, int j) {
		int result = 0;
		Stack<int[]> stack = new Stack<int[]>();
		int[] arr = {i, j};
		int[][] calc = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		stack.add(arr);
		
		while (!stack.isEmpty()) {
			int[] numArr = stack.pop();
			int row = numArr[0];
			int col = numArr[1];
			
			if (row < 0 || row >= map.length || col < 0 || col >= map.length) continue;
			if (visited[row][col]) continue;
			
			result++;
			visited[row][col] = true;
			
			for (int k = 0; k < calc.length; k++) {
				int tempRow = row + calc[k][0];
				int tempCol = col + calc[k][1];
				
				if (tempRow >= 0 && tempRow < map.length && tempCol >= 0 && tempCol < map.length) {
					if (map[tempRow][tempCol] == 1) {
						int[] temp = {tempRow, tempCol};
						stack.add(temp);
					}
				}
			}
		}
		
		return result;
	}
	
	public static void print(ArrayList<Integer> cntList) {
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(cntList);
		
		sb.append(cntList.size()).append("\n");
		
		for (int i = 0; i < cntList.size(); i++) {
			sb.append(cntList.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			
			ArrayList<Integer> cntList = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split("");
				
				for (int j = 0; j < input.length; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] == 1)
						cntList.add(bfs(map, visited, i, j));
				}
			}
			
			print(cntList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
