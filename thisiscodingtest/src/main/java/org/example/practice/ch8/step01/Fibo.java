package org.example.practice.ch8.step01;

import java.io.IOException;

public class Fibo {
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++){
			System.out.print(solution(i) + " ");
		}
	}

	private static int solution(int x){
		if (x <= 1){
			return x;
		}
		return solution(x - 1) + solution(x - 2);
	}
}
