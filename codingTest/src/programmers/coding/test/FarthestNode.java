package programmers.coding.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
	
	public static int bfs(ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size()];
		int size = 0;
		
		queue.add(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int x = queue.poll();
				
				for (int y : graph.get(x)) {
					if (!visited[y]) {
						queue.add(y);
						visited[y] = true;
					}
				}
			}
		}
		
		return size;
	}
	
	public static int solution(int n, int[][] edge) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edge.length; i++) {
			int num1 = edge[i][0];
			int num2 = edge[i][1];
			
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		
		int answer = bfs(graph);
		
		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(solution(n, edge)); // 3
	}
	
}
