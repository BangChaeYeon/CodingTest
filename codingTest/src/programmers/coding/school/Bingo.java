package programmers.coding.school;

import java.util.Arrays;

public class Bingo {
	
	public static int solution(int[][] board, int[] nums) {
		int answer = 0;
		
		for (int n : nums) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == n) {
						board[i][j] = 0;
						break;
					}
				}
			}
		}
		
		for (int[] b : board) {
			System.out.println(Arrays.toString(b));
		}
		
		// 가로 체크
		answer += checkRow(board);
	//	System.out.println(answer);
		// 세로 체크
		answer += checkCol(board);
	//	System.out.println(answer);
		// 왼쪽 대각선 체크
		answer += checkDiagLeft(board);
	//	System.out.println(answer);
		// 오른쪽 대각선 체크
		answer += checkDiagRight(board);
	//	System.out.println(answer);
		
		return answer;
	}
	
	public static int checkRow(int[][] board) {
		int bingoCnt = 0;
		int cNum = 0;
		
		for (int i = 0; i < board.length; i++) {
			cNum = 0;
			
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) cNum += 1;
			}
			
			if (cNum == board.length) bingoCnt += 1;
		}
		
		return bingoCnt;
	}
	
	public static int checkCol(int[][] board) {
		int bingoCnt = 0;
		int cNum = 0;
		
		for (int i = 0; i < board.length; i++) {
			cNum = 0;
			
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i] == 0) cNum += 1;
			}
			
			if (cNum == board.length) bingoCnt += 1;
		}
		
		return bingoCnt;
	}
	
	public static int checkDiagLeft(int[][] board) {
		int bingoCnt = 0;
		int cNum = 0;
		
		for (int i = 0; i < board.length; i++) {
			if (board[i][i] == 0) cNum += 1;
		}
		
		if (cNum == board.length) bingoCnt += 1;
		
		return bingoCnt;
	}
	
	public static int checkDiagRight(int[][] board) {
		int bingoCnt = 0;
		int cNum = 0;
		
		for (int i = 0; i < board.length; i++) {
			if (board[(board.length - 1 -i)][i] == 0) cNum += 1;
		}
		
		if (cNum == board.length) bingoCnt += 1;
		
		return bingoCnt;
	}

	public static void main(String[] args) {
		/*int[][] board = {{11,13,15,16},{12,1,4,3},{10,2,7,8},{5,14,6,9}};
		int[] nums = {14,3,2,4,13,1,16,11,5,15};*/
		
		int[][] board = {{6,15,17,14,23},{5,12,16,13,25},{21,4,2,1,22},{10,20,3,18,8},{11,9,19,24,7}};
		int[] nums = {15,7,2,25,9,16,12,18,5,4,10,13,20};
		
		int result = solution(board, nums);
		System.out.println(result);
	}

}
