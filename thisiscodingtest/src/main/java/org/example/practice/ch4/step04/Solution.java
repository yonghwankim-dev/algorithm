package org.example.practice.ch4.step04;

public class Solution {
	public static int solution(int n, int m, int[] start, int[][] map){
		int y = start[0];
		int x = start[1];
		int direction = start[2];
		boolean[][] visited = new boolean[n][m];
		visited[y][x] = true;

		// 북,동,남,서
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		int count = 1;
		int turnTime = 0;
		while (true){
			direction = turnLeft(direction);
			int ny = dy[direction] + y;
			int nx = dx[direction] + x;

			if (map[ny][nx] == 0 && !visited[ny][nx]){
				visited[ny][nx] = true;
				y = ny;
				x = nx;
				count++;
				turnTime = 0;
				continue;
			}else{
				turnTime++;
			}

			if (turnTime == 4){
				ny = y - dy[direction];
				nx = x - dx[direction];
				if (map[ny][nx] == 0){
					y = ny;
					x = nx;
				}else{
					break;
				}
				turnTime = 0;
			}
		}
		return count;
	}

	private static int turnLeft(int direction){
		direction--;
		if (direction == -1){
			direction = 3;
		}
		return direction;
	}

	public static void main(String[] args) {
		int n = 4;
		int m = 4;
		int[] start = {1, 1, 0};
		int[][] map = {
			{1, 1, 1, 1},
			{1, 0, 0, 1},
			{1, 1, 0, 1},
			{1, 1, 1, 1}
		};
		int answer = solution(n, m, start, map);
		System.out.println(answer);
		assert answer == 3;
	}
}
