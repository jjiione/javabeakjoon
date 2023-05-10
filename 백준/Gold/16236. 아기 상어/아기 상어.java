import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

class Shark{
	public Shark(int r, int c) {
		this.r = r;
		this.c = c;
		this.size = 2;
		this.eat = 0;
	}
	int r;
	int c;
	int size;
	int eat;
	
	public void eat(){
		eat++;
		if(eat == size) {
			size ++;
			eat = 0;
		}
	}
}

public class Main {
	static int N, ans;
	static int map[][];
	static int [] dr = {-1, 0, 1, 0};   // 상 좌 하 우 순서로 탐색
	static int [] dc = {0, -1, 0, 1};
	static Shark shark;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		// map 정보 입력 받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 9)
					shark = new Shark(i, j);
			}
		}
		
		boolean flag = false;
		do {
//			System.out.println("start");
			flag = bfs();
//			System.out.println("ans :: " + ans + " " + shark.r + " " + shark.c);
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
		}while(flag);
		System.out.println(ans);
		
	}


	private static boolean bfs() {
		PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}else {
						return o1[0] - o2[0];
					}
				}
				return o1[2] - o2[2];
			}
		});
//		Queue<int []> queue = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		
		queue.offer(new int [] {shark.r, shark.c, 0});
		visited[shark.r][shark.c] = true;
		map[shark.r][shark.c] = 0;
		while(!queue.isEmpty()) {
			int[] b = queue.poll();
//			System.out.println("queue " + b[0] + " " + b[1] + " " + b[2] + " " +  map[b[0]][b[1]]);
			if(map[b[0]][b[1]] < shark.size && map[b[0]][b[1]] != 0) {
//				System.out.println("잡어먹음");
				map[shark.r][shark.c] = 0;
				map[b[0]][b[1]] = 0;
				shark.r = b[0];
				shark.c = b[1];
				shark.eat();
				ans += b[2];
				return true;
			}
			for(int i=0; i<4; i++) {
				int nr = b[0] + dr[i];
				int nc  = b[1] + dc[i];
				int ns = b[2] + 1;
//				System.out.println("shark size " + shark.size);
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] <= shark.size) {
					
						queue.offer(new int[] {nr, nc, ns});
//						System.out.println(nr + " " + nc + " " + ns);
						visited[nr][nc] = true;
					
					
				}
				
			}
		}
		
		return false;
		
	}

}