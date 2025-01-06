package org.example.practice.ch6.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSortExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = solution(numbers);
		int[] expected = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		System.out.println(Arrays.toString(answer));
		assert Arrays.equals(answer, expected);
	}

	private static int[] solution(int[] numbers){
		int n = numbers.length;

		for (int i = 1; i < n; i++){
			int idx = i;
			for (int j = i - 1; j >= 0; j--){
				if (numbers[i] < numbers[j]){
					idx = j;
				}else{
					break;
				}
			}
			for (int j = i; j > idx; j--){
				swap(j, j-1, numbers);
			}
		}

		return numbers;
	}

	private static void swap(int from, int to, int[] numbers){
		int temp = numbers[from];
		numbers[from] = numbers[to];
		numbers[to] = temp;
	}
}
