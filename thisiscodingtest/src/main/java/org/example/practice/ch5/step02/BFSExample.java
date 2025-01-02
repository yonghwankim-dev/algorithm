package org.example.practice.ch5.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSExample {

	public static int[] solution(LinkedList<Integer>[] graph, int n, int start){
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()){
			Integer node = queue.poll();
			result.add(node);

			for (int adj : graph[node]){
				if (!visited[adj]){
					visited[adj] = true;
					queue.offer(adj);
				}
			}
		}
		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++){
			graph[i] = new LinkedList<>();
		}

		for (int i = 1; i <= n; i++){
			int[] nodes = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int src = nodes[0];
			for (int j = 1; j < nodes.length; j++){
				graph[src].add(nodes[j]);
			}
		}
		int start = 1;
		int[] answer = solution(graph, n, start);
		int[] expected = {1, 2, 3, 8, 7, 4, 5, 6};
		System.out.println(Arrays.toString(answer));
		assert Arrays.equals(answer, expected);
	}
}
