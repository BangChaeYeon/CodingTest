package programmers.coding.school;

import java.util.ArrayList;
import java.util.Arrays;

public class Simulation_Before {
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        ArrayList<Integer> bList = new ArrayList<>();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int b : B) {
        	bList.add(b);
        }
        
        System.out.println(bList.toString());
        
        
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < bList.size(); j++) {
        		if (A[i] < bList.get(j)) {
        			answer += 1;
        			bList.remove(j);
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		
		int result = solution(A, B);
		System.out.println(result);
	}
}
