import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int dp[][] = new int [31][31];
        for(int i=1; i<=30; i++){
            dp[i][1] = i;
        }
        for(int i=2; i<=30; i++){
            for(int j=2; j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k]).append("\n");
        }
        System.out.println(sb);

    }
}