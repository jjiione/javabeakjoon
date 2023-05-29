import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [][] arr;
	static int white, blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(N, 0, 0);
		System.out.println(white);
		System.out.println(blue);

	}

	static void check(int N, int r, int c) {
		if(N == 1){
			if(arr[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}
		boolean flag = true;
		a : for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(arr[r][c] != arr[r+i][c+j]){
					flag = false;
					break a;
				}
			}
		}
		if(!flag){
			check(N/2, r,c);
			check(N/2, r+N/2,  c);
			check(N/2, r, c+N/2);
			check(N/2, r+N/2, c+N/2);
		}else{
			if(arr[r][c] == 0)
				white++;
			else
				blue++;
		}
	}


}