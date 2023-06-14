import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N+1];
		int dp[] = new int[N+1];
		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(N == 1){
			System.out.println(arr[1]);
			return;
		}
		if(N == 2){
			System.out.println(arr[1] + arr[2]);
			return;
		}

		dp[1]= arr[1];
		dp[2] = arr[1] + arr[2];


		for(int i=3; i<=N; i++){
			// i번째를 마실 때
			// i번째를 마시고 i-1번째를 마실 때 - i-2는 무조건 마시면 안됨
			int a = dp[i-3] + arr[i-1] + arr[i];

			// i번째를 마시고 i-1번째를 마시지 않을 때
			int b = dp[i-2] + arr[i];

//			dp[i] = Math.max(a,b);
			// i번째를 마시지 않을 때
			int c = dp[i-1];

			dp[i] = Math.max(Math.max(a,b), c);
		}

		System.out.println(dp[N]);
		



	}

}