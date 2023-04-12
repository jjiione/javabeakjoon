import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = {0, 0, 1, -1, 0, 0};
	static int dc[] = {0, 0, 0, 0, -1, 1};
	static int dh[] = {1, -1, 0, 0, 0, 0};
	static int M, N, H;
	static int graph[][][];
	static Queue<int[]> queue = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		graph = new int[H][N][M];
		for(int h = 0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					graph[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int h = 0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(graph[h][n][m] == 1) {
						queue.add(new int[] {h, n, m, 0});
					}
				}
			}
		}
		int day = bfs();
		boolean flag = true;
		for(int h = 0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(graph[h][n][m] == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		if(flag)
			System.out.println(day);
		else
			System.out.println(-1);
		
		
	}
	
	private static int  bfs() {
		int day = 0;
		while(!queue.isEmpty()) {
			int [] curr = queue.poll();
//			System.out.println(curr[0] + " " + curr[1] + " " + curr[2] + " " +curr[3] + " ");
			day = curr[3];
			for(int i=0; i<6; i++) {
				int nr = curr[1] + dr[i];
				int nc = curr[2] + dc[i];
				int nh = curr[0] + dh[i];
				if( nh>=0 && nh<H && nr>=0 && nr<N && nc>=0 && nc<M && graph[nh][nr][nc] == 0) {
//					System.out.println("queueu");
					queue.offer(new int[] {nh, nr, nc, curr[3] + 1});
					graph[nh][nr][nc] = 1;
				}
			}
		}
		return day;
		
	}

}
