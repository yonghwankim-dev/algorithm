package BOJ.BOJ_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++){
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			graph[src].add(dst);
			graph[dst].add(src);
			Collections.sort(graph[src]);
			Collections.sort(graph[dst]);
		}

		boolean[] dfsVisited = new boolean[n + 1];
		StringBuilder dfsAnswer = new StringBuilder();
		dfs(graph, v, dfsVisited, dfsAnswer);

		boolean[] bfsVisited = new boolean[n + 1];
		StringBuilder bfsAnswer = new StringBuilder();
		bfs(graph, v, bfsVisited, bfsAnswer);

		System.out.println(dfsAnswer.toString().trim());
		System.out.println(bfsAnswer.toString().trim());
	}

	private static void dfs(LinkedList<Integer>[] graph, int v, boolean[] visited, StringBuilder sb) {
		if (visited[v]){
			return;
		}

		visited[v] = true;
		sb.append(v).append(" ");
		for (int adj : graph[v]){
			dfs(graph, adj, visited, sb);
		}
	}

	private static void bfs(LinkedList<Integer>[] graph, int v, boolean[] visited, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(v);

		while (!queue.isEmpty()){
			Integer poll = queue.poll();
			if (visited[poll]){
				continue;
			}

			visited[poll] = true;
			sb.append(poll).append(" ");
			for (int adj : graph[poll]){
				queue.offer(adj);
			}
		}
	}
}
