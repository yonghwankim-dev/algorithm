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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++){
			graph[i] = new LinkedList<>();
		}
		for (int i = 1; i <= n; i++){
			int[] edges = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int src = edges[0];
			for (int j = 1; j < edges.length; j++){
				graph[src].add(edges[j]);
			}
			graph[src].sort(Integer::compareTo);
		}

		int[] answer = solution(n, 1, graph);
		System.out.println(Arrays.toString(answer));
		assert Arrays.equals(answer, new int[]{1, 2, 3, 8, 7, 4, 5, 6});
	}

	private static int[] solution(int n, int start, LinkedList<Integer>[] graph){
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()){
			int node = queue.poll();
			result.add(node);

			for (int adj : graph[node]){
				if (!visited[adj]){
					queue.offer(adj);
					visited[adj] = true;
				}
			}
		}
		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
