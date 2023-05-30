import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean [][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		StringBuilder sb = new StringBuilder();

		recursive(N, 0, 0);

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(arr[i][j])
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void recursive(int n, int r, int c) {
		if(n <= 3){
			arr[r][c] = arr[r][c+1] = arr[r][c+2] = arr[r+1][c] = arr[r+1][c+2] = arr[r+2][c]=
					arr[r+2][c+1]=arr[r+2][c+2] = true;
		}else{
			recursive(n/3, r,c);
			recursive(n/3, r,c+n/3);
			recursive(n/3, r,c+2*n/3);
			recursive(n/3, r+n/3,c);
			recursive(n/3, r+n/3,c+2*n/3);
			recursive(n/3, r+2*n/3,c);
			recursive(n/3, r+2*n/3,c+n/3);
			recursive(n/3, r+2*n/3,c+2*n/3);

		}

	}


}