import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
class Matrix{
    public Matrix(int y, int x){
        this.y = y;
        this.x = x;
    }
    int x;
    int y;
}
public class Main {
    static int arr[][];
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cnt = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
               
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if(tmp == 1)  cnt++;
            }
        }

        int prev = 0;
        int day = 0;
        while(cnt != 0) {
            prev = cnt;
            day++;
            visited = new boolean[N][M];
            bfs();
        }
        System.out.println(day);
        System.out.println(prev);
    }

    private static void bfs() {
        Queue<Matrix> q = new ArrayDeque<>();
        q.offer(new Matrix(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Matrix tmp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    if(arr[ny][nx] == 0) {
                        q.offer(new Matrix(ny, nx));
                    } else {
                        cnt--;
                        arr[ny][nx] = 0;
                    }
                }
            }
        }
    }

}