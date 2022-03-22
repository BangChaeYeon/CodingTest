package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_11286 {
	
	static ArrayList<Integer> absHeap;
	
	public static void insert(int num) {
		absHeap.add(num);
		
		int idx = absHeap.size() - 1;
		while (idx > 1 
				&& (Math.abs(absHeap.get(idx)) < Math.abs(absHeap.get(idx / 2)) 
				|| (Math.abs(absHeap.get(idx)) == Math.abs(absHeap.get(idx / 2)) && absHeap.get(idx) < absHeap.get(idx / 2)))) {
			int temp = absHeap.get(idx);
			absHeap.set(idx, absHeap.get(idx / 2));
			absHeap.set(idx / 2, temp);
			
			idx /= 2;
		}
	}
	
	public static int delete() {
		if (absHeap.size() == 1) return 0;
		
		int delVal = absHeap.get(1);
		
		absHeap.set(1, absHeap.get(absHeap.size() - 1));
		absHeap.remove(absHeap.size() - 1);
		
		int idx = 1;
		while (idx * 2 < absHeap.size()) {
			int minIdx = idx * 2;
			int compareIdx = idx * 2 + 1;
			int min = absHeap.get(minIdx);
			
			if (compareIdx < absHeap.size() 
				&& (Math.abs(min) > Math.abs(absHeap.get(compareIdx))
				|| (Math.abs(min) == Math.abs(absHeap.get(compareIdx)) && min > absHeap.get(compareIdx)))) {
				minIdx = compareIdx;
				min = absHeap.get(minIdx);
			}
			
			if (Math.abs(min) > Math.abs(absHeap.get(idx))
				|| (Math.abs(min) == Math.abs(absHeap.get(idx)) && min > absHeap.get(idx))) break;
			else {
				int temp = absHeap.get(idx);
				absHeap.set(idx, min);
				absHeap.set(minIdx, temp);
				idx = minIdx;
			}
		}
		
		return delVal;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			absHeap = new ArrayList<>();
			absHeap.add(0);
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if (num == 0) {
					sb.append(delete()).append("\n");
				} else {
					insert(num);
				}
			}
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
