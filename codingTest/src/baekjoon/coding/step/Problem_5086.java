package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5086 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = null;
			
			while (true) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				if (num1 == 0 && num2 == 0) break;
				
				if (num2 % num1 == 0) {
					sb.append("factor").append("\n");
				} else if (num1 % num2 == 0) {
					sb.append("multiple").append("\n");
				} else {
					sb.append("neither").append("\n");
				}
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
