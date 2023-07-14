import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [][] arr;
    static int [] dr = {1, 0, -1, 0};
    static int [] dc={0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] || arr[i][j] == 0){
                    continue;
                }
                queue.offer(bfs(i, j));

            }
        }
        sb.append(queue.size()).append("\n");
        while(!queue.isEmpty()){
            sb.append(queue.poll()).append("\n");
        }
        System.out.println(sb);




    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            cnt++;
            for(int i=0; i<4; i++){
                int nr = dr[i] + curr[0];
                int nc = dc[i] + curr[1];
                if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || arr[nr][nc] == 0){
                    continue;
                }
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;

            }
        }
        return cnt;
    }
}