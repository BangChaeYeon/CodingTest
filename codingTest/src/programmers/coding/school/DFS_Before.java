package programmers.coding.school;

import java.util.Stack;

public class DFS_Before {
	
	public static int solution(int n) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[2]);
        
        while (!stack.isEmpty()) {
        	int[] sArr = stack.pop();
        	int openCnt = sArr[0];
        	int closeCnt = sArr[1];
        	
        	if (openCnt > n || openCnt < closeCnt) {
        		continue;
        	}
        	
        	if (openCnt == n && closeCnt == n) {
        		answer += 1;
        		continue;
        	}
        	
        	int[] s1 = {openCnt + 1, closeCnt};
        	stack.push(s1);
        	
        	int[] s2 = {openCnt, closeCnt + 1};
        	stack.push(s2);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 4; // 2
	//	int n = 3; // 5
		
		System.out.println(solution(n));
	}
}
