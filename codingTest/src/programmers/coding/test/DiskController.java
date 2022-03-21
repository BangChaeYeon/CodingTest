package programmers.coding.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
	
	static class Task implements Comparable<Task> {
		int request;
		int required;
		
		public Task(int request, int required) {
			this.request= request;
			this.required = required;
		}
		
		@Override
		public int compareTo(Task o) {
			return Integer.compare(required, o.required);
		}
	}
	
	public static int solution(int[][] jobs) {
		PriorityQueue<Task> priQueue = new PriorityQueue<>();
		Task[] taskList = new Task[jobs.length];
		int answer = 0;
		int time = 0;
		int idx = 0;
		int cnt = 0;
		
		Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
		
		while (cnt < jobs.length) {
			for (int i = idx; i < taskList.length; i++) {
				if (time >= jobs[i][0]) {
					Task task = new Task(jobs[i][0], jobs[i][1]);
					priQueue.offer(task);
					idx++;
				}
			}
			
			if (priQueue.isEmpty()) {
				time = jobs[idx][0];
			} else {
				Task pTask = priQueue.poll();
				
				answer += time + pTask.required - pTask.request;
				time += pTask.required;
				cnt++;
			}
		}
		
		return (int) Math.floor(answer/jobs.length);
	}
	
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		System.out.println(solution(jobs)); // 9
	}
	
}
