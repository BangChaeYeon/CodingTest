package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2931 {
	
	public static int gcd (int num1, int num2) {
		while (num2 != 0) {
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		
		return num1;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] numbers = new int[n];
			
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(numbers);
			
			int gcdNum = numbers[1] - numbers[0];
			for (int i = 2; i < n; i++) {
				gcdNum = gcd(gcdNum, numbers[i] - numbers[i - 1]);
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 2; i <= gcdNum; i++) {
				if (gcdNum % i == 0) {
					sb.append(i).append(" ");
				}
			}
			
			System.out.println(sb.toString().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
