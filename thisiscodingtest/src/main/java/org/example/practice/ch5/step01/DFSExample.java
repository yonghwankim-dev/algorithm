package org.example.practice.ch5.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFSExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		LinkedList[] graph = new LinkedList[n+1];

		for (int i = 1; i <= n; i++){
			graph[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i <= n; i++){
			int[] edges = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int src = edges[0];
			for (int j = 1; j < edges.length; j++){
				graph[src].add(edges[j]);
			}
		}

		int[] expected = {1, 2, 7, 6, 8, 3, 4, 5};
		int[] actual = solution(n, graph);
		System.out.println(Arrays.toString(actual));
		assert Arrays.equals(actual, expected);
	}

	private static int[] solution(int n, LinkedList[] graph){
		boolean[] visited = new boolean[n + 1];
		List<Integer> result = new ArrayList<>();
		int start = 1;
		dfs(graph, visited, start, result);
		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private static void dfs(LinkedList<Integer>[] graph, boolean[] visited, int start, List<Integer> result){
		if (visited[start]){
			return;
		}
		result.add(start);
		visited[start] = true;

		for (int adj : graph[start]){
			if (!visited[adj]){
				dfs(graph, visited, adj, result);
			}
		}
	}
}
