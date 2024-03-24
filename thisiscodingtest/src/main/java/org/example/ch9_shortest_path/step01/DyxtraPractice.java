package org.example.ch9_shortest_path.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class DyxtraPractice {

	public static int[] solution(int n, int start, LinkedList<int[]>[] graph){
		// distance 배열 초기화
		boolean[] visited = new boolean[n + 1];
		int[] distance = new int[n + 1];
		for (int i = 0; i <= n; i++){
			distance[i] = Integer.MAX_VALUE;
		}

		// 시작 노드 초기화
		visited[start] = true;
		distance[start] = 0;
		for(int[] adj : graph[start]){
			distance[adj[0]] = adj[1];
		}

		// 스타드 노드를 제외한 n-1개의 노드를 대상으로 최단 경로 탐색 반복
		for (int i = 1; i <= n; i++){
			int smallestNode = getSmallestNode(n, distance, visited);
			visited[smallestNode] = true;
			for (int[] adj : graph[smallestNode]){
				distance[adj[0]] = Math.min(distance[adj[0]], distance[smallestNode] + adj[1]);
			}
		}
		return distance;
	}

	private static int getSmallestNode(int n, int[] distance, boolean[] visited) {
		int minValue = Integer.MAX_VALUE;
		int result = 1;
		for (int i = 1; i <= n; i++){
			if (distance[i] < minValue && !visited[i]){
				minValue = distance[i];
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		int n = 6;
		int start = 1;
		String[] inputs = {
			"1 2 2",
			"1 4 1",
			"1 3 5",
			"2 3 3",
			"2 4 2",
			"3 2 3",
			"3 6 5",
			"4 3 3",
			"4 5 1",
			"5 3 1",
			"5 6 2"};
		LinkedList<int[]>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++){
			graph[i] = new LinkedList<>();
		}

		for (String input : inputs){
			String[] split = input.split(" ");
			int src = Integer.parseInt(split[0]);
			int dest = Integer.parseInt(split[1]);
			int dist = Integer.parseInt(split[2]);
			graph[src].add(new int[]{dest, dist});
		}

		int[] answer = solution(n, start, graph);
		System.out.println(Arrays.toString(answer));
	}
}
