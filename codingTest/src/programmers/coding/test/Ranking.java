package programmers.coding.test;

public class Ranking {
	
	public static int solution(int n, int[][] results) {
		int[][] ranking = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					ranking[i][j] = 101;
				}
			}
		}
		
		for (int i = 0; i < results.length; i++) {
			int x = results[i][0] - 1;
			int y = results[i][1] - 1;
			
			ranking[x][y] = 1;
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ranking[i][j] = Math.min(ranking[i][j], ranking[i][k] + ranking[k][j]);
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			
			for (int j = 0; j < n; j++) {
				if (i != j && (ranking[i][j] < 101 || ranking[j][i] < 101)) count++;
			}
			
			if (count == n - 1) result++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println(solution(n, results)); // 2
	}

}
