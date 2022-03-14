package baekjoon.coding.step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1931 {
	
	public static int getMeetingCount(int[][] meetingRooms) {
		int count = 0;
		int time = 0;
		
		for (int i = 0; i < meetingRooms.length; i++) {
			int start = meetingRooms[i][0];
			int end = meetingRooms[i][1];
			
			if (time <= start) {
				time = end;
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = null;
			
			int n = Integer.parseInt(br.readLine());
			int[][] meetingRooms = new int[n][2];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				meetingRooms[i][0] = Integer.parseInt(st.nextToken());
				meetingRooms[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(meetingRooms, (o1, o2) -> (o1[1] != o2[1]) ? o1[1] - o2[1] : (o1[0] - o2[0]));
			
			System.out.println(getMeetingCount(meetingRooms));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
