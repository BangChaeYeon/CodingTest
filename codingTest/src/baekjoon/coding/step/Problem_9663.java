package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_9663 {
	static int[] chess;
	static boolean[] chkRow;
	static boolean[] chkDiagLeft;
	static boolean[] chkDiagRight;
	static int correctCnt = 0;
	
	public static void getQueenCnt(int cIdx){
		if (cIdx >= chess.length) {
			correctCnt++;
			return;
		}
		
		for (int i = 0; i < chess.length; i++) {
			if (!chkRow[i] && !chkDiagLeft[cIdx + i] && !chkDiagRight[cIdx - i + chess.length - 1]) {
				chess[cIdx] = i;
				chkRow[i] = chkDiagLeft[cIdx + i] = chkDiagRight[cIdx - i + chess.length - 1] = true;
				getQueenCnt(cIdx + 1);
				chkRow[i] = chkDiagLeft[cIdx + i] = chkDiagRight[cIdx - i + chess.length - 1] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int size = Integer.parseInt(br.readLine());
			chess = new int[size];
			chkRow = new boolean[size];
			chkDiagLeft = new boolean[(size * 2 - 1)];
			chkDiagRight = new boolean[(size * 2 - 1)];
			
			getQueenCnt(0);
			
			System.out.println(correctCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
