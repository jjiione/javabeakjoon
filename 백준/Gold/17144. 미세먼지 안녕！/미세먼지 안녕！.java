import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int map[][];
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int dr2[] = {-1, 0, 1, 0};
	static int dc2[] = {0, 1, 0, -1};
	static int cleaner[];
	static int R,C,T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cleaner = new int [2];
		int ans = 0;

		// 배열 입력받기
		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 공기 청정기 위치 찾기 - 항상 첫번째 열에 존재한다.
		for(int i=0; i<R; i++){
			if(map[i][0] == -1){
				cleaner[0] = i;
				cleaner[1] = i+1;
				break;
			}
		}

		for(int t= 0; t<T; t++) {
			// 먼지 확산
			moveDust();

			// 공기 청정기 가동
			moveCleaner();
		}

		// 정답 출력
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				ans += map[i][j];
			}
		}

		System.out.println(ans + 2);  // 공기청정기때문에 -2 생기므로 2 더해주기

	}

	private static void moveDust() {
		int add[][] = new int[R][C]; // 확산된 먼지량 저장하는 배열(동시에 확산되므로 따로 저장 필요)
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(map[i][j] >= 5){  // 확산할 먼지가 있을 때
					int cnt = 4;
					for(int k=0; k<4; k++){
						int nr = dr[k] + i;
						int nc = dc[k] + j;
						if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc] == -1){
							cnt--;
							continue;
						}
						add[nr][nc] += map[i][j]/5;
					}
					add[i][j] -= cnt*(map[i][j]/5);
				}

			}
		}


		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				map[i][j] += add[i][j];
			}
		}
	}

	private static void moveCleaner() {
		int up = cleaner[0];
		int down = cleaner[1];

		// 시계방향 회전
		int curr_r = down+1;
		int curr_c = 0;
		int cnt = 0;

		for(int i=0; i<(R-down-2+C)*2-2; i++){
			int nr = curr_r + dr[cnt];
			int nc = curr_c + dc[cnt];
			if(nr<down || nc<0 || nr>=R || nc>=C){
				cnt ++;
				nr = curr_r + dr[cnt];
				nc = curr_c + dc[cnt];
			}

			map[curr_r][curr_c] = map[nr][nc];
			curr_r = nr;
			curr_c =nc;
		}
		map[down][1] = 0;

		// 반시계 회전
		curr_r = up-1;
		curr_c = 0;
		cnt = 0;

		for(int i=0; i<((up)+C-1)*2-2; i++){
			int nr = curr_r + dr2[cnt];
			int nc = curr_c + dc2[cnt];

			if(nr<0 || nc<0 || nr>up || nc>=C){
				cnt = (cnt+1)%4;
				nr = curr_r + dr2[cnt];
				nc = curr_c + dc2[cnt];
			}

			map[curr_r][curr_c] = map[nr][nc];
			curr_r = nr;
			curr_c =nc;
		}
		map[up][1] = 0;

	}


}