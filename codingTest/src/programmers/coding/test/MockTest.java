package programmers.coding.test;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
	
	static class Student {
		int[] answer;
		int aIdx = 0;
		int correctCnt = 0;
		
		public Student(int[] answer){
			this.answer = answer;
		}
		
		public void correntAnswer(int a){
			if (this.answer[this.aIdx] == a) {
				this.correctCnt += 1;
			}
			
			this.aIdx++;
			if (this.aIdx == this.answer.length) this.aIdx = 0;
		}
	}
	
	public static int[] solution(int[] answers) {
		int[] a1 = {1, 2, 3, 4, 5};
		int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		Student s1 = new Student(a1);
		Student s2 = new Student(a2);
		Student s3 = new Student(a3);
		Student[] students = {s1, s2, s3};
		
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < students.length; j++) {
				students[j].correntAnswer(answers[i]);
			}
		}
		
		ArrayList<Integer> answerList = new ArrayList<>();
		int maxNum = Math.max(Math.max(students[0].correctCnt, students[1].correctCnt), Math.max(students[0].correctCnt, students[2].correctCnt));
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].correctCnt == maxNum) answerList.add(i + 1);
		}
		
		return answerList.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int[] answers1 = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(solution(answers1))); // [1]
		
		// Test Case 02
		int[] answers2 = {1,3,2,4,2};
		
		System.out.println(Arrays.toString(solution(answers2))); // [1,2,3]
	}
}
