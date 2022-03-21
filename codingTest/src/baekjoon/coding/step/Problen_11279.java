package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problen_11279 {
	
	static ArrayList<Integer> maxHeap;
	
	public static void insert(int num) {
		maxHeap.add(num);
		
		int idx = maxHeap.size() - 1;
		while (idx > 1 && maxHeap.get(idx) > maxHeap.get(idx / 2)) {
			int temp = maxHeap.get(idx / 2);
			maxHeap.set(idx / 2, maxHeap.get(idx));
			maxHeap.set(idx, temp);
			
			idx /= 2;
		}
	}
	
	public static int delete() {
		if (maxHeap.size() == 1) return 0;
		
		int delVal = maxHeap.get(1);
		
		maxHeap.set(1, maxHeap.get(maxHeap.size() - 1));
		maxHeap.remove(maxHeap.size() - 1);
		
		int idx = 1;
		while (idx * 2 < maxHeap.size()) {
			int maxIdx = idx * 2;
			int compareIdx = idx * 2 + 1;
			int max = maxHeap.get(maxIdx);
			
			if (compareIdx < maxHeap.size() && max < maxHeap.get(compareIdx)) {
				max = maxHeap.get(compareIdx);
				maxIdx = compareIdx;
			}
			
			if (max < maxHeap.get(idx)) break;
			else {
				int temp = maxHeap.get(idx);
				maxHeap.set(idx, max);
				maxHeap.set(maxIdx, temp);
				idx = maxIdx;
			}
		}
		
		return delVal;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			maxHeap = new ArrayList<>();
			maxHeap.add(0);
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if (num == 0) {
					sb.append(delete()).append("\n");
				} else {
					insert(num);
				}
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
