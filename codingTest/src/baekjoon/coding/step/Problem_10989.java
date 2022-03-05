package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem_10989 {
	
	/*
	 * private static void mergeSort(int[] numbers, int start, int end, int[] temp)
	 * { if (start >= end) return;
	 * 
	 * int mid = (start + end) / 2;
	 * 
	 * mergeSort(numbers, start, mid, temp); mergeSort(numbers, mid + 1, end, temp);
	 * 
	 * int i = start, j = mid + 1, idx = start; while (i <= mid || j <= end) { if (j
	 * > end || (i <= mid && numbers[i] <= numbers[j])) temp[idx++] = numbers[i++];
	 * else temp[idx++] = numbers[j++]; }
	 * 
	 * for (int k = start; k <= end; k++) { numbers[k] = temp[k]; } }
	 */
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int size = Integer.parseInt(br.readLine());
			int[] numbers = new int[size];
		//	int[] temp = new int[size];
			int i = 0;
			
			for (i = 0; i < size; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			
		//	mergeSort(numbers, 0, size - 1, temp);
			Arrays.sort(numbers);
			
			for (i = 0; i < size; i++) {
				bw.write(numbers[i] + "\n");
			}
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
