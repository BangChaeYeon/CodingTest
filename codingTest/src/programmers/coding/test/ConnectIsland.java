package programmers.coding.test;

import java.util.Arrays;

public class ConnectIsland {
	
	static int[] parent;
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}
	
	public static int find(int num) {
		if (parent[num] == num) return num;
		else return find(parent[num]);
	}
	
	public static int solution(int n, int[][] costs) {
		int minCost = 0;
		int[][] island = new int[costs.length][3];
		parent = new int[n];
		
		for (int i = 0; i < costs.length; i++) {
			island[i][0] = costs[i][0];
			island[i][1] = costs[i][1];
			island[i][2] = costs[i][2];
		}
		
		Arrays.sort(island, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < island.length; i++) {
			if (find(island[i][0]) != find(island[i][1])) {
				union(island[i][0], island[i][1]);
				minCost += island[i][2];
			}
		}
		
		return minCost;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n, costs)); // 	4
	}
	
}
