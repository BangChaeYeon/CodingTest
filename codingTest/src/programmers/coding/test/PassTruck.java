package programmers.coding.test;

import java.util.LinkedList;
import java.util.Queue;

public class PassTruck {
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<>();
		
		int time = 0;
		int thisWeight = 0;
		for (int truck : truck_weights) {
			while (true) {
				if (queue.isEmpty()) {
					queue.offer(truck);
					thisWeight += truck;
					time++;
					break;
				} else if (queue.size() == bridge_length) {
					thisWeight -= queue.poll();
				} else {
					if (weight >= thisWeight + truck) {
						queue.offer(truck);
						thisWeight += truck;
						time++;
						break;
					} else {
						queue.offer(0);
						time++;
					}
				}
			}
		}
		
		return time + bridge_length;
	}
	
	public static void main(String[] args) {
		// Tese Case 01
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7,4,5,6};
		
		System.out.println(solution(bridge_length1, weight1, truck_weights1)); // 8
		
		// Tese Case 02
		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10};
		
		System.out.println(solution(bridge_length2, weight2, truck_weights2)); // 101
		
		// Tese Case 03
		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(solution(bridge_length3, weight3, truck_weights3)); // 110
	}
	
}
