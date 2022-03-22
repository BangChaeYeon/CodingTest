package programmers.coding.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePriorityQueue {
	
	public static int[] solution(String[] operations) {
		int[] answer = {0, 0};
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		StringTokenizer st;
		
		for (String op : operations) {
			st = new StringTokenizer(op);
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if (command.equals("I")) {
				maxQueue.offer(num);
				minQueue.offer(num);
			} else {
				if (num == -1) {
					if (minQueue.peek() != null) maxQueue.remove(minQueue.poll());
				} else {
					if (maxQueue.peek() != null) minQueue.remove(maxQueue.poll());
				}
			}
		}
		
		if (!maxQueue.isEmpty()) answer[0] = maxQueue.peek();
		if (!minQueue.isEmpty()) answer[1] = minQueue.peek();
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String[] operations1 = {"I 16","D 1"};
		
		System.out.println(Arrays.toString(solution(operations1))); // [0,0]
		
		// Test Case 02
		String[] operations2 = {"I 7","I 5","I -5","D -1"};
		
		System.out.println(Arrays.toString(solution(operations2))); // [7,5]
	}
	
}
