package org.example.practice.ch6.step01;

import java.util.Arrays;

public class SelectionSortExample {
	public static int[] solution(int[] arr, int n){
		int[] answer = Arrays.copyOf(arr, n);
		for (int i = 0; i < n - 1; i++){
			int minIdx = i;
			for (int j = i + 1; j < n; j++){
				if (answer[j] < answer[minIdx]){
					minIdx = j;
				}
			}
			swap(answer, i, minIdx);
		}
		return answer;
	}

	private static void swap(int[] arr, int from, int to){
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = 10;
		int[] answer = solution(arr, n);
		int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.toString(answer));
		assert Arrays.equals(answer, expected);
	}
}
