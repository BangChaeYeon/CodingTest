package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2447 {
	static char starMap[][];

	public static void drawStars(int i, int j, int sNum) {
		if ((i / sNum) % 3 == 1 && (j / sNum) % 3 == 1) {
			starMap[i][j] = ' ';
		} else {
			if (sNum / 3 == 0) {
				starMap[i][j] = '*';
			} else {
				drawStars(i, j, (sNum / 3));
			}
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int sNum = Integer.parseInt(br.readLine());
			starMap = new char[sNum][sNum];
			
			for (int i = 0; i < sNum; i++) {
				for (int j = 0; j < sNum; j++) {
					drawStars(i, j, sNum);
				}
				bw.write(starMap[i]);
				bw.write("\n");
			}
			
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
