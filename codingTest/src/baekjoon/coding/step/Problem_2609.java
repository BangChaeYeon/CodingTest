package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2609 {
	
	public static int gcd(int n1, int n2) {
		while (n2 != 0) {
			int temp = n1 % n2;
			
			n1 = n2;
			n2 = temp;
		}
		
		return n1;
	}
	
	public static int lcd(int n1, int n2) {
		return n1 * n2 / gcd(n1, n2);
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			System.out.println(gcd(num1, num2));
			System.out.println(lcd(num1, num2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
