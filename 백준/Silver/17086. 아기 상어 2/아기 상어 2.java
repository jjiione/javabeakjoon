import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char [][]arr;
    static int [] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int [] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int N, M, ans;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];


        for(int i=0; i<N; i++){
            String str = br.readLine().replace(" ", "");
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bfs(i,j, 0);
            }
        }
        System.out.println(ans);

    }

    private static void bfs(int y, int x, int cnt) {
        Queue<int[]> queue = new ArrayDeque();
        int[] current = null;
        visited = new boolean[N][M];

        queue.offer(new int[]{y, x, cnt});
        a: while(!queue.isEmpty()){
            current = queue.poll();
            visited[y][x] = true;
            if(arr[current[0]][current[1]] == '1')
                break;

            for(int i= 0 ; i<8; i++){
                if(current[1]+dx[i]>=0 && current[1]+dx[i] <M && current[0]+dy[i] >=0 && current[0]+dy[i] <N && !visited[current[0]+dy[i]][current[1]+dx[i]]){
//                    if(arr[y+dy[i]][x+dx[i]] == '1')
//                        break a;
                    queue.offer(new int[]{ current[0]+dy[i], current[1]+dx[i], current[2]+1});
                    visited[current[0]+dy[i]][current[1]+dx[i]] = true;
                }

            }


        }
        ans = Math.max(ans, current[2]);

    }
}