package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_1655 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minQueue = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if (minQueue.size() == maxQueue.size()) {
					maxQueue.offer(num);
				} else {
					minQueue.offer(num);
				}
				
				if (!minQueue.isEmpty() && !maxQueue.isEmpty()
					&& minQueue.peek() < maxQueue.peek()) {
					maxQueue.offer(minQueue.poll());
					minQueue.offer(maxQueue.poll());
				}
				
				sb.append(maxQueue.peek()).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
