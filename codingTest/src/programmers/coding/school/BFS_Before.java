package programmers.coding.school;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Before {
	
	static class Position {
		int x;
		int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int solution(int[][] maps) {
		int mapHeight = maps.length;
		int mapWidth = maps[0].length;
		
		int area[][] = new int[mapHeight][mapWidth];
		boolean[][] visited = new boolean[mapHeight][mapWidth];
		
		mapHeight -= 1;
		mapWidth -= 1;
		
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(0, 0));
		area[0][0] = 1;
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			Position currentPos = queue.poll();
			
			int thisX = currentPos.x;
			int thisY = currentPos.y;
			int depth = area[thisX][thisY] + 1;
			
			// 위로 이동
			if (thisX > 0 && maps[thisX - 1][thisY] == 1 && !visited[thisX - 1][thisY]) {
				queue.offer(new Position(thisX - 1, thisY));
				area[thisX - 1][thisY] = depth;
				visited[thisX - 1][thisY] = true;
			}
			
			// 아래로 이동
			if (thisX < mapWidth && maps[thisX + 1][thisY] == 1 && !visited[thisX + 1][thisY]) {
				queue.offer(new Position(thisX + 1, thisY));
				area[thisX + 1][thisY] = depth;
				visited[thisX + 1][thisY] = true;
			}
			
			// 왼쪽으로 이동
			if (thisY > 0 && maps[thisX][thisY - 1] == 1 && !visited[thisX][thisY - 1]) {
				queue.offer(new Position(thisX, thisY - 1));
				area[thisX][thisY - 1] = depth;
				visited[thisX][thisY - 1] = true;
			}
			
			// 오른쪽으로 이동
			if (thisY < mapHeight && maps[thisX][thisY + 1] == 1 && !visited[thisX][thisY + 1]) {
				queue.offer(new Position(thisX, thisY + 1));
				area[thisX][thisY + 1] = depth;
				visited[thisX][thisY + 1] = true;
			}
			
		}
		
		for (int[] m : maps) {
			System.out.println(Arrays.toString(m));
		}
		
		System.out.println();
		
		for (int[] a : area) {
			System.out.println(Arrays.toString(a));
		}
		
		return area[mapWidth][mapHeight] == 0 ? -1 : area[mapWidth][mapHeight];
	}

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
	//	int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		System.out.println(solution(maps));
	}

}
