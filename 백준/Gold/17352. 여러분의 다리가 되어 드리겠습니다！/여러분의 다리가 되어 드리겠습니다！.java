import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[]visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<N-2; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		bfs(N);
		int ans = 0;
		for(int i=1; i<=N; i++){
			if(!visited[i])
				ans = i;
		}
		if(ans != 1){
			System.out.println("1 " + ans);
		}else
			System.out.println("2 "+ ans);
	}

	private static void bfs(int N) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		int cnt = 1;
		int curr = 0;
		visited[1] = true;

		while(!queue.isEmpty()){
			curr = queue.poll();
			for(int a: graph[curr]){
				if(visited[a])
					continue;
				queue.offer(a);
				visited[a] = true;
			}
		}


	}


}