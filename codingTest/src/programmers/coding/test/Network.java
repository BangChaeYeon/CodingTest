package programmers.coding.test;

public class Network {
	static int cnt = 0;
	
	public static void findNetwork(int[][] computers, int idx, boolean[] chk) {
		chk[idx] = true;
		
		for (int i = 0; i < computers.length; i++) {
			if (!chk[i] && idx != i && computers[idx][i] == 1) {
				findNetwork(computers, i, chk);
			}
		}
	}
	
	public static int solution(int n, int[][] computers) {
		boolean[] chk = new boolean[n];
		cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (!chk[i]) {
				findNetwork(computers, i, chk);
				cnt++;
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int n1 = 3;
		int[][] network1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		System.out.println(solution(n1, network1)); // 2
		
		// Test Case 01
		int n2 = 3;
		int[][] network2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n2, network2)); // 1
	}
}
