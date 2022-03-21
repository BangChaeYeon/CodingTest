package programmers.coding.test;

import java.util.PriorityQueue;

public class MoreSpicy {
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> priQueue = new PriorityQueue<>();
		int cnt = 0;
		
		for (int s : scoville) {
			priQueue.offer(s);
		}
		
		while (priQueue.peek() < K) {
			if (priQueue.size() < 2) return -1;
			
			int n1 = priQueue.poll();
			int n2 = priQueue.poll();
			int mix = n1 + n2 * 2;
			
			cnt++;
			priQueue.offer(mix);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(solution(scoville, K)); // 2
	}
	
}
