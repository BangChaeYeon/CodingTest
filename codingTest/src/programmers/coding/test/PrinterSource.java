package programmers.coding.test;

import java.util.LinkedList;
import java.util.Queue;

public class PrinterSource {
	
	static class Printer {
        int location;
        int importance;
        
        public Printer(int location, int importance) {
            this.location = location;
            this.importance = importance;
        }
    }
    
    public static boolean isMax(Queue<Printer> queue, int num) {
    	Printer[] pArr = new Printer[queue.size()];
        int max = 0;
        
        for (int i = 0; i < pArr.length; i++) {
            pArr[i] = queue.poll();
            max = Math.max(pArr[i].importance, max);
        }
        
        for (Printer p : pArr) {
            queue.offer(p);
        }
        
        return num >= max;
    }
    
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
        	Printer printer = new Printer(i, priorities[i]);
            queue.offer(printer);
        }
        
        while (!queue.isEmpty()) {
        	Printer printer = queue.poll();
            
            if (isMax(queue, printer.importance)) {
                answer++;
                if (printer.location == location) break;
            } else {
                queue.offer(printer);
            }
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// Test Case 01
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;
		
		System.out.println(solution(priorities1, location1)); // 1
		
		// Test Case 02
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		
		System.out.println(solution(priorities2, location2)); // 5
	}
	
}
