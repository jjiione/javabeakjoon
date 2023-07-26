import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        Queue<long[]> queue = new ArrayDeque<>();

        queue.add(new long[]{A, 0});
        long ans = Long.MAX_VALUE;

        while(!queue.isEmpty()){
            long curr[] = queue.poll();
            if(curr[0] < B){
                queue.add(new long[]{curr[0]*10 + 1, curr[1] + 1});
                queue.add(new long[]{curr[0] * 2, curr[1] + 1});
            }else if(curr[0] == B){
                ans = Math.min(ans, curr[1]);
            }
        }

        if(ans == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans + 1);

        }


    }
}