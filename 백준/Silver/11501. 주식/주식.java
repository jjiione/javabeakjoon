import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            long ans = 0;
            int idx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int [] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[N-1];
            int cost = 0;
            int day = 0;
            for(int i=N-2; i>= 0; i--){
                if(max<=arr[i]){
                    ans += day*max - cost;
                    max = arr[i];
                    cost = 0;
                    day = 0;

                }else{
                    cost += arr[i];
                    day++;
                }

            }
            ans += day*max - cost;


            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}