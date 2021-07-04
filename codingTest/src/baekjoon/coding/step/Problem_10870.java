package baekjoon.coding.step;

import java.util.Scanner;

public class Problem_10870 {

	public static int fibonacci(int n, int fArr[]) {
		if (n != 0 && fArr[n] == 0) {
			fArr[n] = fibonacci(n - 1, fArr) + fibonacci(n - 2, fArr);
		}
		
		return fArr[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int fNum = sc.nextInt();
		int fArr[] = new int[fNum + 1];
		int result;
		
		if(fNum < 2) {
			result = fNum;
		} else {
			fArr[1] = fArr[2] = 1;
			result = fibonacci(fNum, fArr);
		}
		
		System.out.println(result);
	}

}
