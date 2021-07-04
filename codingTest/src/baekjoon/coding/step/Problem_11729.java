package baekjoon.coding.step;

import java.util.Scanner;

public class Problem_11729 {
	static StringBuilder steps = new StringBuilder();
	static int moveCnt = 0;
	
	public static void hanoiTower(int no, int x, int y) {
		if (no > 1) {
			hanoiTower((no - 1), x, (6 - x - y));
		}
		
		steps.append(x + " " + y);
		steps.append("\n");
		moveCnt++;
		
		if (no > 1) {
			hanoiTower((no - 1), (6 - x - y), y);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hNum = sc.nextInt();
		
		hanoiTower(hNum, 1, 3);
		
		System.out.println(moveCnt);
		System.out.println(steps);
	}

}
