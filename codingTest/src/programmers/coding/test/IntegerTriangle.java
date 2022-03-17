package programmers.coding.test;

public class IntegerTriangle {
	
	public static int solution(int[][] triangle) {
		for (int i = triangle.length - 1; i > 0; i--) {
			for (int j = 1; j < triangle[i].length; j++) {
				triangle[i - 1][j - 1] += Math.max(triangle[i][j - 1], triangle[i][j]);
			}
		}
		
		return triangle[0][0];
	}
	
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(solution(triangle)); // 30
	}
	
}
