import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Matrix {
    int y;
    int x;
    int day;
    public Matrix(int y, int x, int day){
        this.y = y;
        this.x = x;
        this.day = day;
    }
}
public class Main {
    static int tomato [][];
    static int sum, N, M;
    static int total;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};
    static Queue<Matrix> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int [N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                tomato[i][j] = tmp;
                if(tmp == 1){
                    queue.offer(new Matrix(i, j, 0));
                    total ++;
                    sum ++;
                }
                if(tmp == 0){
                    total++;
                }
            }
        }
//        System.out.println(total + " " + sum);

        int res = bfs();
        if(total == sum)
            System.out.println(res);
        else
            System.out.println(-1);

    }

    private static int bfs() {

        int ans = 0;
        while(!queue.isEmpty()){
            Matrix curr = queue.poll();
            ans = curr.day;
            for(int i=0; i<4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && tomato[ny][nx] == 0) {
                    tomato[ny][nx] = 1;
                    sum++;
                    queue.offer(new Matrix(ny, nx, curr.day+1));
                }
            }
        }
        return ans;


    }
}