package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem_1541 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] formula = br.readLine().split("\\-");
			int total = 0;
			
			for (int i = 0; i < formula.length; i++) {
				String[] form = formula[i].split("\\+");
				
				if (i == 0) {
					if (form.length == 1) {
						total += Integer.parseInt(form[0]);
					} else {
						int temp = 0;
						
						for (int j = 0; j < form.length; j++) {
							temp += Integer.parseInt(form[j]);
						}
						
						total += temp;
					}
				} else {
					if (form.length == 1) {
						total -= Integer.parseInt(form[0]);
					} else {
						int temp = 0;
						
						for (int j = 0; j < form.length; j++) {
							temp += Integer.parseInt(form[j]);
						}
						
						total -= temp;
					}
				}
			}
			
			System.out.println(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
