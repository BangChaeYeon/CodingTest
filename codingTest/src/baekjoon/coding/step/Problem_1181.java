package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Problem_1181 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int len = Integer.parseInt(br.readLine());
			ArrayList<String> wordList = new ArrayList<String>();
			
			for (int i = 0; i < len; i++) {
				String word = br.readLine();
				
				if (!wordList.contains(word)) {
					wordList.add(word);
				}
			}
			
			wordList.sort(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if (s1.length() != s2.length()) {
						return s1.length() > s2.length() ? 1 : -1;
					} else {
						return s1.compareTo(s2);
					}
				}
			});
			
			for (int i = 0; i < wordList.size(); i++) {
				if (wordList.get(i) != null)
					sb.append(wordList.get(i)).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
