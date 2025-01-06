package org.example.practice.ch6.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSortExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = solution(numbers);
		System.out.println(Arrays.toString(answer));
		int[] expected = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		assert Arrays.equals(answer, expected);
	}

	private static int[] solution(int[] numbers){
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++){
			int minValue = numbers[i];
			int minIdx = i;
			for (int j = i + 1; j < n; j++){
				if (minValue > numbers[j]){
					minValue = numbers[j];
					minIdx = j;
				}
			}
			swap(i, minIdx, numbers);
		}
		return numbers;
	}

	private static void swap(int from, int to, int[] numbers){
		int temp = numbers[from];
		numbers[from] = numbers[to];
		numbers[to] = temp;
	}
}
