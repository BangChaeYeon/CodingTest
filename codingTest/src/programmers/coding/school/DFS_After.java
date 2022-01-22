package programmers.coding.school;

import java.util.Stack;

public class DFS_After {
	
	/*static class Data {
		int openCount, closeCount;

		Data(int openCount, int closeCount){
			this.openCount = openCount;
			this.closeCount = closeCount;
		}
	}
	
	public static int solution(int n) {
		int answer = 0;

		Stack<Data> stack = new Stack<>();
		stack.push(new Data(0,0));

		while(!stack.isEmpty()){
			Data cur = stack.pop();
			
			if (cur.openCount > n || cur.openCount < cur.closeCount)
				continue;
			if(cur.closeCount == n && cur.openCount == n){
				answer++;
				continue;
			}
			
			stack.push(new Data(cur.openCount + 1, cur.closeCount));
			stack.push(new Data(cur.openCount, cur.closeCount + 1));
		}
		
		return answer;
	}*/
	
	private static int result;

	public static int solution(int n) {
		function(n, 0, 0);
		return result / (n + 1); // ? 풀기는 풀었는데 대체 왜임
	}

	private static void function(int n, int sum, int cnt) {
		if (cnt >= n * 2) {
			if (sum == 0) result++;
			return;
		}
		
		function(n, sum + 1, cnt + 1);
		function(n, sum - 1, cnt + 1);
	}
	
	public static void main(String[] args) {
		int n = 5;
	//	int n = 3;
		
		System.out.println(solution(n));
	}
}
