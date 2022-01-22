package programmers.coding.school;

import java.util.Arrays;

public class IntTriangle_Before {
	
	public static int solution(int[][] triangle) {
		triangle[1][0] = triangle[0][0] + triangle[1][0];
		triangle[1][1] = triangle[0][0] + triangle[1][1];
		
		for (int i = 2; i < triangle.length; i++) {
			int len = triangle[i].length - 1;
			triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
			triangle[i][len] = triangle[i - 1][i - 1] + triangle[i][len];
			
			for (int j = 1; j < len; j++) {
				triangle[i][j] = Math.max(triangle[i][j], Math.max((triangle[i - 1][j - 1] + triangle[i][j]), (triangle[i - 1][j] + triangle[i][j])));
			}
		}
		
		/*for (int[] m : maxNum) {
			System.out.println(Arrays.toString(m));
		}*/
		
		return Arrays.stream(triangle[(triangle.length - 1)]).max().getAsInt();
	}
	
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(solution(triangle)); // 30
	}

}
