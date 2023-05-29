import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char [][] board = new char[N][M];
		int ans = Integer.MAX_VALUE;

		// 보드판 입력 받기
		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				board[i][j] = str.charAt(j);
			}
		}

		// 보드판 탐색하면서 최솟값 갱신하기
		for(int i=0; i<N-8+1; i++){
			for(int j=0; j<M-8+1; j++){
				char flag1 = 'B';
				char flag2 = 'W';
				int sum1 = 0;
				int sum2 = 0;
				for(int a=0; a<8; a++){
					for(int b=0; b<8; b++){
						if(board[i+a][j+b] != flag1)
							sum1++;
						if(flag1 == 'B')
							flag1 = 'W';
						else
							flag1 = 'B';

						if(board[i+a][j+b] != flag2)
							sum2++;
						if(flag2 == 'B')
							flag2 = 'W';
						else
							flag2 = 'B';
					}
					if(flag1 == 'B')
						flag1 = 'W';
					else
						flag1 = 'B';

					if(flag2 == 'B')
						flag2 = 'W';
					else
						flag2 = 'B';
				}

				ans = Math.min(sum1, ans);
				ans = Math.min(sum2, ans);
			}
		}
		System.out.println(ans);

	}

}