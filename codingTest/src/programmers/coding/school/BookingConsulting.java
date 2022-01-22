package programmers.coding.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookingConsulting {
	
	static String thisTime = "";
	
	static class Customer {
		String time;
		String name;
		
		Customer(String time, String name){
			this.time = time;
			this.name = name;
		}
	}
	
	public static void AddTime() {
		int hour = Integer.parseInt(thisTime.split(":")[0]);
		int minute = Integer.parseInt(thisTime.split(":")[1]) + 10;
		
		if (minute == 60) {
			hour += 1;
			minute = 0;
		}
		
		thisTime = hour + ":" + (minute == 0 ? "00" : minute);
	}
	
	public static String[] solution(String[][] booked, String[][] unbooked) {
		List<Customer> bList = new ArrayList<>();
		List<Customer> ubList = new ArrayList<>();
		
		int totalLen = booked.length + unbooked.length;
		String[] answer = new String[totalLen];
		
		int bIdx = 0, ubIdx = 0;
		
		if (booked[0][0].compareTo(unbooked[0][0]) > 0) {
			thisTime = unbooked[0][0];
			answer[0] = unbooked[0][1];
			ubIdx += 1;
		} else {
			thisTime = booked[0][0];
			answer[0] = booked[0][1];
			bIdx += 1;
		}
		
		AddTime();
		
		for (int i = 1; i < totalLen; i++) {
			if (bIdx == booked.length) {
				answer[i] = unbooked[ubIdx][1];
				ubIdx += 1;
			} else if (ubIdx == unbooked.length) {
				answer[i] = booked[bIdx][1];
				bIdx += 1;
			} else {
				if (thisTime.compareTo(booked[bIdx][0]) <= 0) {
					answer[i] = booked[bIdx][1];
					bIdx += 1;
				} else if (thisTime.compareTo(unbooked[ubIdx][0]) <= 0) {
					answer[i] = unbooked[ubIdx][1];
					ubIdx += 1;
				} else {
					if (booked[bIdx][0].compareTo(unbooked[ubIdx][0]) >= 0) {
						thisTime = booked[bIdx][0];
						answer[i] = booked[bIdx][1];
						bIdx += 1;
					} else {
						thisTime = unbooked[ubIdx][0];
						answer[i] = unbooked[ubIdx][1];
						ubIdx += 1;
					}
				}
			}
			
			AddTime();
		}
		
		
		/*for (String[] b : booked) {
			Customer customer = new Customer(b[0], b[1]);
			bList.add(customer);
		}
		
		for (String[] ub : unbooked) {
			Customer customer = new Customer(ub[0], ub[1]);
			ubList.add(customer);
		}
		
		Collections.sort(cList);*/
		
	//	String[] answer = cList.stream().map(c -> c.name).toArray(String[]::new);
		
		return answer;
	}
	
	public static void main(String[] args) {
		/*String[][] booked = {{"09:10", "lee"}};
		String[][] unbooked = {{"09:00", "kim"}, {"09:05", "bae"}};*/
		
		String[][] booked = {{"09:55", "hae"}, {"10:05", "jee"}};
		String[][] unbooked = {{"10:04", "hee"}, {"14:07", "eom"}};
		
		System.out.println(Arrays.toString(solution(booked, unbooked)));
	}
	
}
