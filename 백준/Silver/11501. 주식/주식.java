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
            PriorityQueue <int []> queue = new PriorityQueue<>((o1, o2)->{
                if(o1[0] != o2[0])
                    return Integer.compare(o2[0], o1[0]);
                else
                    return Integer.compare(o2[1], o2[1]);
            });
            int [] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{arr[i], i});
            }

            for(int i=0; i<N; i++){
                if(i > queue.peek()[1]){
                    queue.poll();
                    i--;
                }else if(i < queue.peek()[1]){
                    ans += queue.peek()[0] - arr[i];
                }else{
                    queue.poll();
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}