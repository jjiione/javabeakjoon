import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R;
	static int dr[] = {1, 0 , -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int arr [][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L =Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = true;
		int ans = 0;

		while(flag){
			int tmp = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(visited[i][j])
						continue;
					tmp += bfs(i, j);
				}
			}
			if(tmp == 0){ // 인구 이동이 하나도 없었다는 의미
				flag = false;
			}
			else{
				ans++;
			}

		}
		System.out.println(ans);
	}

	// bfs 돌리기
	private static int bfs(int r, int c){
		Queue <int []> queue = new ArrayDeque<>();
		queue.offer(new int[]{r,c});
		visited[r][c] = true;
		int cnt = 1;
		int people = arr[r][c];
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[]{r, c});

		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			for(int i=0; i<4; i++){
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] ||
						Math.abs(arr[curr[0]][curr[1]] -arr[nr][nc]) < L || Math.abs(arr[curr[0]][curr[1]] -arr[nr][nc]) > R)
					continue;
				queue.offer(new int[]{nr, nc});
				list.add(new int[]{nr ,nc});
				visited[nr][nc] = true;
				cnt++;
				people += arr[nr][nc];
			}
		}
		update(list, people/cnt);

		return cnt-1;

	}

	// 인구 업데이트
	private static void update(ArrayList<int[]> list, int p){
		for(int i=0; i<list.size(); i++){
			int [] curr = list.get(i);
			arr[curr[0]][curr[1]] = p;
		}

	}
}