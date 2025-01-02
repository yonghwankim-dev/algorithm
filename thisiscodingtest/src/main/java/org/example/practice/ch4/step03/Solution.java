package org.example.practice.ch4.step03;

public class Solution {
	public static int solution(String position){
		String[] split = position.split("");
		String cols = "abcdefgh";
		int n = 8;
		int x = cols.indexOf(split[0]) + 1;
		int y = Integer.parseInt(split[1]);

		// 상좌, 상우, 하좌, 하우, 좌상, 좌하, 우상, 우하
		int[] dy = {-2, -2, 2, 2, -1, 1, -1, 1};
		int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
		int answer = 0;

		for (int i = 0; i < n; i++){
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (ny <= 0 || ny > n || nx <= 0 || nx > n){
				continue;
			}
			answer++;
		}

		return answer;
	}
	public static void main(String[] args) {
		int answer = solution("a1");
		assert answer == 2;

		answer = solution("c2");
		System.out.println(answer);
		assert answer == 6;
	}
}
