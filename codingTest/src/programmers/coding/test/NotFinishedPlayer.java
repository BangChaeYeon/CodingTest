package programmers.coding.test;

import java.util.HashMap;
import java.util.Map;

public class NotFinishedPlayer {
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> personInfo = new HashMap<>(); 
		
		for(String parti : participant){
			if(personInfo.containsKey(parti)) 
				personInfo.put(parti, personInfo.get(parti) + 1);
			else
				personInfo.put(parti, 1);
		}
		
		for(int i = 0; i < completion.length; i++){
			if(personInfo.containsKey(completion[i])){
				personInfo.put(completion[i], personInfo.get(completion[i]) - 1);
			}
		}
		
		for(Object key : personInfo.keySet()){
			if(personInfo.get(key) == 1){
				answer = key.toString();
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// Test Case 01
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		
		System.out.println(solution(participant1, completion1)); // leo
		
		// Test Case 02
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(solution(participant2, completion2)); // vinko
		
		// Test Case 03
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant3, completion3)); // mislav
	}
}
