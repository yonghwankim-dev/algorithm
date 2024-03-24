package org.example.ch11_gridy.step03;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		String s = "0001100";
		int answer = solution(s);
		System.out.println(answer);
	}

	private static int solution(String s) {
		int[] numbers = Arrays.stream(s.split(""))
			.mapToInt(Integer::parseInt)
			.toArray();
		int count0 = 0; // 전부 0으로 변경하는 횟수
		int count1 = 0; // 전부 1로 변경하는 횟수

		if (numbers[0] == 1){
			count0++;
		}else{
			count1++;
		}

		for (int i = 0; i < numbers.length - 1; i++){
			if (numbers[i] != numbers[i+1]){
				// 다음 수에서 1로 바꾸는 경우
				if (numbers[i+1] == 1){
					count0++;
				}else{
					count1++;
				}
			}
		}
		return Math.min(count0, count1);
	}
}
