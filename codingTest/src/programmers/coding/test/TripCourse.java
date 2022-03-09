package programmers.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripCourse {
	static ArrayList<String> cityList = new ArrayList<>();
	
	public static void dfs(String[][] tickets, boolean[] visited, String city, int cnt, String cities) {
		if (cnt >= tickets.length) {
			cityList.add(cities);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(city)) {
				visited[i] = true;
				dfs(tickets, visited, tickets[i][1], cnt + 1, cities + ";" + tickets[i][1]);
				visited[i] = false;
			}
		}
	}
	
	public static String[] solution(String[][] tickets) {
		boolean[] visited = new boolean[tickets.length];
		String start = "ICN";
		
		dfs(tickets, visited, start, 0, start);
		
		Collections.sort(cityList);
		
		return cityList.get(0).split(";");
	}
	
	public static void main(String[] args) {
		// Test Case 01
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		
		System.out.println(Arrays.toString(solution(tickets1))); // ["ICN", "JFK", "HND", "IAD"]
		
		// Test Case 02
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		System.out.println(Arrays.toString(solution(tickets2))); // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
	}
}
