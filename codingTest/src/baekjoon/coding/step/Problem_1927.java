package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Problem_1927 {
	
	static ArrayList<Integer> minHeap;
	
	public static void insert(int num) {
		minHeap.add(num);
		
		int idx = minHeap.size() - 1;
		while (idx > 1 && minHeap.get(idx / 2) > minHeap.get(idx)) {
			int temp =  minHeap.get(idx / 2);
			minHeap.set(idx / 2, minHeap.get(idx));
			minHeap.set(idx, temp);
			
			idx /= 2;
		}
	}
	
	public static int delete() {
		if (minHeap.size() == 1) return 0;
		
		int delVal = minHeap.get(1);
		
		minHeap.set(1, minHeap.get(minHeap.size() - 1));
		minHeap.remove(minHeap.size() - 1);
		
		int idx = 1;
		while (idx * 2 < minHeap.size()) {
			int minIdx = idx * 2;
			int compareIdx = idx * 2 + 1;
			int min = minHeap.get(minIdx);
			
			if (compareIdx < minHeap.size() && min > minHeap.get(compareIdx)) {
				min = minHeap.get(compareIdx);
				minIdx = compareIdx;
			}
			
			if (min > minHeap.get(idx)) break;
			else {
				int temp = minHeap.get(idx);
				minHeap.set(idx, min);
				minHeap.set(minIdx, temp);
				idx = minIdx;
			}
		}
		
		return delVal;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			minHeap = new ArrayList<>();
			minHeap.add(0);
			
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if (num == 0) {
					bw.write(delete() + "\n");
				} else {
					insert(num);
				}
			}
			
			bw.flush();
			if (br != null) br.close();
			if (bw != null) bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
