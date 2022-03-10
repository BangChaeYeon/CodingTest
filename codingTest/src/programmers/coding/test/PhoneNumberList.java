package programmers.coding.test;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
	
	public static boolean solution(String[] phone_book) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String phone : phone_book) {
			map.put(phone, map.getOrDefault(phone, 0));
		}
		
		for(String key : map.keySet()){
			for (int i = 0; i < key.length(); i++) {
				if (map.containsKey(key.substring(0, i))) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// Test Case 01
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book1)); // false
		
		// Test Case 02
		String[] phone_book2 = {"123","456","789"};
		
		System.out.println(solution(phone_book2)); // true
		
		// Test Case 03
		String[] phone_book3 = {"12","123","1235","567","88"};
		
		System.out.println(solution(phone_book3)); // false
	}
}
