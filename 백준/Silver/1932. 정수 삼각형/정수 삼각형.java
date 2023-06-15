import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int [N+1][N+1];
		int dp[][] = new int [N+1][N+1];
		for(int i=1; i<=N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++){
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		int ans = 0;

		for(int i=1; i<=N; i++){
			ans = Math.max(ans, dp[N][i]);
		}

		System.out.println(ans);
		

	}

}