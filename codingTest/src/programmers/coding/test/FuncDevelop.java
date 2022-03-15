package programmers.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FuncDevelop {
	
	public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(progresses[i]);
        }
        
        int count = 0;
        int initNum = 0;
        
        while (!queue.isEmpty()) {
            int idx = initNum;
            int num = queue.peek();
            
            if (num >= 100) {
                count++;
                initNum++;
                queue.remove();
            } else {
                if (count != 0) {
                    result.add(count);
                    count = 0;
                }
                
                for (int i = idx; i < speeds.length; i++) {
                    int q = queue.poll();
                    queue.offer(q + speeds[i]);
                }
            }  
        }
        
        result.add(count);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
	
	public static void main(String[] args) {
		// Test Case 01
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution(progresses1, speeds1))); // 2, 1
		
		// Test Case 02
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses2, speeds2))); // 1, 3, 2
	}
	
}
