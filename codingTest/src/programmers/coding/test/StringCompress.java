package programmers.coding.test;

public class StringCompress {
	
	public static int compress(String s) {
		int len = s.length();
		
		for (int i = 1; i < s.length(); i++) {
			String comStr = "";
			String checkStr = s.substring(0, i);
			int checkNum = 0, j = 0;
			
			for (j = 0; (j + i - 1) < s.length(); j += i) {
				if (checkStr.equals(s.substring(j, (j + i)))) {
					checkNum++;
				} else {
					comStr += (checkNum == 1 ? "" : checkNum) + checkStr;
					checkNum = 1;
					checkStr = s.substring(j, (j + i));
				}
			}
			
			comStr += (checkNum == 1 ? "" : checkNum) + checkStr;
			
			if(j < s.length()) comStr += s.substring(j);
		//	System.out.println(comStr);
			
			if (comStr.length() < len) {
				len = comStr.length();
			}
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		String test01 = "aabbaccc";
		System.out.println(compress(test01));
		
		String test02 = "ababcdcdababcdcd";
		System.out.println(compress(test02));
		
		String test03 = "abcabcdede";
		System.out.println(compress(test03));
		
		String test04 = "abcabcabcabcdededededede";
		System.out.println(compress(test04));
		
		String test05 = "xababcdcdababcdcd";
		System.out.println(compress(test05));
	}
}
