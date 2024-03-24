package org.example.ch9_shortest_path.step02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DyxtraPractice {
	private static int[] solution(int n, int start, LinkedList<int[]>[] graph) {
		int[] distance = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

		for (int i = 0; i <= n; i++){
			distance[i] = Integer.MAX_VALUE;
		}

		queue.offer(new int[]{start, 0});
		distance[start] = 0;

		while(!queue.isEmpty()){
			int[] now = queue.poll();
			visited[now[0]] = true;

			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			if (distance[now[0]] < now[1]){
				continue;
			}

			for (int[] adj : graph[now[0]]){
				int cost = distance[now[0]] + adj[1];
				if (cost < distance[adj[0]]){
					distance[adj[0]] = cost;
					queue.offer(new int[]{adj[0], cost});
				}
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		int n = 6;
		int m = 11;
		int start = 1;
		LinkedList<int[]>[] graph = new LinkedList[n + 1];
		for (int i = 0; i <= n; i++){
			graph[i] = new LinkedList<>();
		}

		String[] inputs = {
			"1 2 2",
			"1 3 5",
			"1 4 1",
			"2 3 3",
			"2 4 2",
			"3 2 3",
			"3 6 5",
			"4 3 3",
			"4 5 1",
			"5 3 1",
			"5 6 2"
		};

		for (String input : inputs){
			int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			int src = arr[0];
			int dst = arr[1];
			int dist = arr[2];
			graph[src].add(new int[]{dst, dist});
		}

		int[] distance = solution(n, start, graph);
		System.out.println(Arrays.toString(distance));
	}
}
