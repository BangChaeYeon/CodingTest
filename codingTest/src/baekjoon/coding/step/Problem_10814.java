package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_10814 {
	
	private static class Member {
		int age;
		String name;
		int regSort;
		
		private Member() {
			super();
		}
		
		private Member(int age, String name, int regSort) {
			this.age = age;
			this.name = name;
			this.regSort = regSort;
		}
		
		@Override
		public String toString() {
			return age + " " + name;
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int cnt = Integer.parseInt(br.readLine());
			Member[] members = new Member[cnt];
			
			for (int i = 0; i < cnt; i++) {
				String[] input = br.readLine().split(" ");
				
				members[i] = new Member(Integer.parseInt(input[0]), input[1], i);
			}
			
			Arrays.sort(members, new Comparator<Member>() {
				@Override
				public int compare(Member m1, Member m2) {
					if (m1.age != m2.age) {
						return m1.age > m2.age ? 1 : -1;
					} else {
						return m1.regSort > m2.regSort ? 1 : -1;
					}
				}
			});
			
			for (int i = 0; i < cnt; i++) {
				sb.append(members[i].toString()).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

}
