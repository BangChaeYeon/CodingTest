package programmers.coding.school;

import java.util.Arrays;

public class VirusIncrease {
	
	public static int[][] scope = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public static boolean[][] check;
	
	public static void addVirus (int[][] virus, int row, int col, int max_virus) {
		int rowsLen = virus.length;
		int columnsLen = virus[0].length;
		check[row][col] = false;
		
		if (virus[row][col] < max_virus) { // 바이러스가 최대값 미만일 때
			virus[row][col] += 1;
		} else { // 바이러스가 최대값 이상일 때
			for (int i = 0; i < scope.length; i++) {
				int r = row + scope[i][0];
				int c = col + scope[i][1];
				
				if (r >= 0 && r < rowsLen && c >= 0 && c < columnsLen) { // 배열 범위 체크
					if (check[r][c]) addVirus(virus, r, c, max_virus);
				}
			}
		}
	}
	
	public static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
		int[][] answer = new int[rows][columns];
		check = new boolean[rows][columns];
		
		for (int[] query : queries) {
			for (boolean[] c : check) {
				Arrays.fill(c, true);
			}
			
			addVirus(answer, (query[0] - 1), (query[1] - 1), max_virus);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int rows = 3;
		int columns = 4;
		int max_virus = 2;
		int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
		
		int[][] result = solution(rows, columns, max_virus, queries);
		
		/*for (int[] r : result) {
			System.out.println(Arrays.toString(r));
		}*/
	}

}
