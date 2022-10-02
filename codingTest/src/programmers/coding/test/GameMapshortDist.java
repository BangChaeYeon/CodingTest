package programmers.coding.test;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapshortDist {
	
	static int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] visited;
	
	public static int solution(int[][] maps) {
		visited = new int[maps.length][maps[0].length];
		
		move(maps);
		
		int answer = visited[maps.length - 1][maps[0].length - 1];
		
		return answer == 0 ? -1 : answer;
	}
	
	public static void move(int[][] maps) {
		Queue<int[]> queue = new LinkedList<>();
		
		visited[0][0] = 1;
		queue.add(new int[]{0, 0});
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			
			if (x == maps.length - 1 && y == maps[0].length - 1) {
				break;
			}
			
			for (int i = 0; i < moving.length; i++) {
				int moveX = x + moving[i][0];
				int moveY = y + moving[i][1];
				
				// 이동 위치 체크
				if (moveX < 0 || moveX > maps.length - 1
					|| moveY < 0 || moveY > maps[0].length - 1
					|| maps[moveX][moveY] == 0
					|| visited[moveX][moveY] != 0) {
					continue;
				}
				
				visited[moveX][moveY] = visited[x][y] + 1;
				queue.add(new int[]{moveX, moveY});
			}
		}
	}
	
	public static void main(String[] args) {
		// Test Case 01
		int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps1)); // 11
		
		// Test Case 02
		int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(solution(maps2)); // -1
	}

}
