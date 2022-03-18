package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1753 {
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int[] dist;
	
	public static class Node implements Comparable<Node>{
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> priQueue = new PriorityQueue<>();
		priQueue.add(new Node(start, 0));
		
		while (!priQueue.isEmpty()) {
			Node node = priQueue.poll();
			int idx = node.idx;
			int cost = node.cost;
			
			if (dist[idx] < cost) continue;
			
			for (int i = 0; i < list.get(idx).size(); i++) {
				int tempIdx = list.get(idx).get(i).idx;
				int tempCost = list.get(idx).get(i).cost + cost;
				
				if (dist[tempIdx] > tempCost) {
					dist[tempIdx] = tempCost;
					priQueue.add(new Node(tempIdx, tempCost));
				}
			}
		}
	}
	
	public static void print(int V) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(dist[i]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(br.readLine());
			
			dist = new int[V + 1];
			
			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<>());
			}
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				list.get(u).add(new Node(v, w));
			}
			
			dijkstra(start);
			
			print(V);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
