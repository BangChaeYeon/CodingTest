package programmers.coding.test;

public class ExpressN {
	static int answer = -1;
	
	public static void dfs(int n, int number, int sum, int cnt) {
		if (cnt > 8) {
			return;
		}
		
		if (number == sum) {
			if (answer == -1) answer = cnt;
			else answer = Math.min(answer, cnt);
		}
		
		int num = n;
		for (int i = 1; i <= 8 - cnt; i++) {
			dfs(n, number, sum + num, cnt + i);
			dfs(n, number, sum - num, cnt + i);
			dfs(n, number, sum * num, cnt + i);
			dfs(n, number, sum / num, cnt + i);
			num = 10 * num + n;
		}
	}
	
	public static int solution(int N, int number) {
		dfs(N, number, 0, 0);
		
		return answer;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int n1 = 5;
		int number1 = 12;
		
		System.out.println(solution(n1, number1)); // 4
		
		// Test Case 02
		int n2 = 2;
		int number2 = 11;
		
		System.out.println(solution(n2, number2)); // 3
	}
	
}
