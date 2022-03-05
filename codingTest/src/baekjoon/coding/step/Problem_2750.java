package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_2750 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int size = Integer.parseInt(br.readLine());
			int[] numbers = new int[size];
			int i = 0;
			
			for (i = 0; i < size; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(numbers);
			
			for (i = 0; i < size; i++) {
				System.out.println(numbers[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
