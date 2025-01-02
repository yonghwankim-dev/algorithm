package org.example.practice.ch5.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFSExample {
	public static int[] solution(LinkedList<Integer>[] graph, int n){
		boolean[] visited = new boolean[n + 1];
		List<Integer> result = dfs(graph, 1, visited);
		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private static List<Integer> dfs(LinkedList<Integer>[] graph, int v, boolean[] visited) {
		List<Integer> result = new ArrayList<>();
		if (visited[v]){
			return result;
		}
		result.add(v);
		visited[v] = true;
		for (int adj : graph[v]){
			result.addAll(dfs(graph, adj, visited));
		}
		return result;
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
		int[] answer = solution(graph, n);
		int[] expected = {1, 2, 7, 6, 8, 3, 4, 5};
		System.out.println(Arrays.toString(answer));
		assert Arrays.equals(answer, expected);
	}
}
