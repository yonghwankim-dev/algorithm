package org.example.practice.ch8.step02;

public class Fibo {
	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n];
		for (int i = 0; i < 10; i++){
			int answer = solution(i, dp);
			System.out.print(answer + " ");
		}
	}

	private static int solution(int x, int[] dp){
		if (x <= 1){
			return x;
		}
		if (dp[x] != 0){
			return dp[x];
		}
		dp[x] = solution(x - 2, dp) + solution(x - 1, dp);
		return dp[x];
	}
}
