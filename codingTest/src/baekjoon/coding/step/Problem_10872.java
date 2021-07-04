package baekjoon.coding.step;

import java.util.Scanner;

public class Problem_10872 {
	
	public static int factorial(int n, int fArr[]) {
		if (n < 2) {
			return 1;
		} else {
			if(fArr[n - 1] == 0) {
				fArr[n - 1] = factorial((n - 1), fArr) * n;
			}
		}
		
		return fArr[n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int fNum = sc.nextInt();
		int fArr[] = new int[fNum];
		int result = factorial(fNum, fArr);
		
		System.out.println(result);
	}

}
