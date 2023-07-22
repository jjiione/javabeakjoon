import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [][] campus = new char[N][M];
		int startR = 0;
		int startC = 0;
		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				campus[i][j] = str.charAt(j);
				if(campus[i][j] == 'I'){
					startR = i;
					startC = j;
				}
			}
		}

		int ans = bfs(N, M, startR, startC, campus);
		if(ans == 0){
			System.out.println("TT");
		}
		else{
			System.out.println(ans);

		}


	}

	private static int bfs(int N, int M, int startR, int startC, char [][]campus){
		int ans = 0;
		boolean visited [][] = new boolean[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{startR, startC});
		visited[startR][startC] = true;
		int dr [] = {1, 0, -1, 0};
		int dc[] = {0, 1, 0, -1};

		while(!queue.isEmpty()){
			int [] curr = queue.poll();
			for(int i=0; i<4; i++){
				int nr = dr[i] + curr[0];
				int nc = dc[i] + curr[1];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || campus[nr][nc] == 'X')
					continue;
				if(campus[nr][nc] == 'P')
					ans++;
				visited[nr][nc] = true;
				queue.add(new int[]{nr, nc});
			}
		}

		return ans;
	}

}