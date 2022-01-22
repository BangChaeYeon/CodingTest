package programmers.coding.school;

import java.util.*;

public class BFS_After {
	
	public static class Node {
		public int x;
		public int y;
		public int cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	private static final int[] moveX = {1, -1, 0, 0};
	private static final int[] moveY = {0, 0, 1, -1};

	public static int solution(int[][] maps) {
		int answer = -1;
		final int mapSizeX = maps.length;
		final int mapSizeY = maps[0].length;

		boolean[][] visited = new boolean[mapSizeX][mapSizeY];
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();

			if (curNode.x == mapSizeX - 1 && curNode.y == mapSizeY - 1) {
				answer = curNode.cnt;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = curNode.x + moveX[i];
				int nextY = curNode.y + moveY[i];

				if (nextX < 0 || nextX >= mapSizeX || nextY < 0 || nextY >= mapSizeY)
					continue;
				if (maps[nextX][nextY] == 0)
					continue;
				if (visited[nextX][nextY])
					continue;

				visited[nextX][nextY] = true;
				queue.offer(new Node(nextX, nextY, curNode.cnt + 1));
			}

		}
		
		for (boolean[] v : visited) {
			System.out.println(Arrays.toString(v));
		}

		return answer;
	}
	
	/*public static int solution(int[][] maps) {
		final int[] dx = {1, -1, 0, 0};
		final int[] dy = {0, 0, 1, -1};

		final int mX = maps[0].length;
		final int mY = maps.length;

		final int visited[][] = new int[mY][mX];

		Queue<Integer[]> que = new LinkedList<>();
		que.add(new Integer[]{0, 0});
		visited[0][0] = 1;

		while (!que.isEmpty()) {
			Integer[] poll = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = poll[0] + dx[i];
				int nextY = poll[1] + dy[i];

				if (nextX < 0 || nextX >= mX) continue;
				if (nextY < 0 || nextY >= mY) continue;

				if (maps[nextY][nextX] == 0) continue;

				if (visited[nextY][nextX] == 0) {
					visited[nextY][nextX] = visited[poll[1]][poll[0]] + 1;
					
					que.add(new Integer[]{nextX, nextY});
					if (nextX == mX - 1 && nextY == mY - 1) break;
				}

			}
		}
		
		return visited[mY - 1][mX - 1] == 0 ? -1 : visited[mY - 1][mX - 1];
	}*/

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
	//	int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		System.out.println(solution(maps));
	}

}
