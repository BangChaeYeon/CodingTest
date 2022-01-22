package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_1018 {
	
	private static boolean chess[][];
	private static int minNum = Integer.MAX_VALUE;
	
	public static void paint(int x, int y){
		int pCnt = 0;
		boolean tile = chess[x][y];
		
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				if(chess[i][j] != tile) pCnt++;
				
				tile = !tile;
			}
			
			tile = !tile;
		}
		
		pCnt = Math.min(pCnt, 64 - pCnt);
		
		minNum = Math.min(minNum, pCnt);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String a1[] = br.readLine().split(" ");
			
			int row = Integer.parseInt(a1[0]);
			int col = Integer.parseInt(a1[1]);
			
			chess = new boolean[row][col];
			
			for(int i = 0; i < row; i++){
				String str = br.readLine();
				
				for(int j = 0; j < col; j++){
					chess[i][j] = (str.charAt(j) == 'B'); // B일때 true, W일때 false
				}
			}
			
			for(int i = 0; i < row - 7; i++) {
				for(int j = 0; j < col - 7; j++) {
					paint(i, j);
				}
			}
			
			System.out.println(minNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
