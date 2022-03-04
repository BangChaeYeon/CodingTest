package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_1436 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int num = Integer.parseInt(br.readLine());
			int i = 666, cnt = 1;
			
			while (cnt != num) {
				i++;
				
				if (String.valueOf(i).indexOf("666") > -1) {
					cnt++;
				}
			}
			
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
