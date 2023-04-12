import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {1, -1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N, ans;
	static int graph[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int day = 0;
		graph = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				graph[i][j] = tmp;
				day = Math.max(tmp, day);
			}
		}
		
	
		for(int d=0; d<=day; d++) {
			boolean [][] visited = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(graph[i][j]<=d) {
						visited[i][j] = true;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
//						System.out.println("bfs start");
						bfs(visited, i,j);
						cnt++;
					}
				}
			}
//			System.out.println(cnt);
			
			ans = Math.max(ans, cnt);
	
		}
		
		System.out.println(ans);
		
		
	}
	private static void bfs(boolean [][] visited, int r, int c) {
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		queue.offer(new int[] {r, c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int [] curr = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
//					System.out.println("queueu");
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}			
	}

}
