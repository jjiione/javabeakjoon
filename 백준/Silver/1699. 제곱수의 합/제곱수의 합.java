import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> square = new ArrayList<>();
        int n= 1;
        while((int) Math.pow(n, 2)<=N){
            square.add((int) Math.pow(n++, 2));

        }

        int dp[] = new int[N+1];
        for(int i=1; i<=N; i++){
            int num = Integer.MAX_VALUE;
            for(int j=0; j<square.size(); j++){
                if(square.get(j) > i)
                    break;
                num = Math.min(num, dp[i-square.get(j)] + 1);
            }
            dp[i] = num;
        }

        System.out.println(dp[N]);

    }
}