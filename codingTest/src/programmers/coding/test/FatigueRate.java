package programmers.coding.test;

public class FatigueRate {
	static int answer = 0;
	static boolean[] visited;
	
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		adventure(k, dungeons, 0, 0);
		
		return answer;
	}
	
	public static void adventure(int k, int[][] dungeons, int pos, int cnt){
		if (pos == dungeons.length) {
			answer = Math.max(answer, cnt);
		}
		
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				
				if (k >= dungeons[i][0]) {
					adventure((k - dungeons[i][1]), dungeons, pos + 1, cnt + 1);
				} else {
					adventure(k, dungeons, pos + 1, cnt);
				}
				
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20}, {50,40}, {30,10}};
		
		System.out.println(solution(k, dungeons)); // 3
	}
}
