package org.example.ch11_gridy.step04;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int n = 5;
		int[] nums = {3, 2, 1, 1, 9};
		int answer = solution(nums, n);
		System.out.println(answer);
	}

	private static int solution(int[] nums, int n) {
		Arrays.sort(nums);
		int target = 1;
		for (int num : nums) {
			// 만들수 없는 금액을 찾았을 때 반복 종료
			if (target < num){
				break;
			}
			target += num;
		}
		return target;
	}
}
