import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dfs로 탐색하면서 모든 곳을 방문 했을 때 시작점으로 돌아올 수 있느지 check
// 1-2-3-4 나 2-3-4-1 이나 결국 비용은 동일하므로 무조건 1에서 출발해서 1로 돌아온다고 생각한다.
public class Main {
    static int arr [][];
    static int ans = Integer.MAX_VALUE;
    static int N;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited[1] = true;
        dfs(1, 0, 1);
        System.out.println(ans);

    }

    private static void dfs(int node, int sum, int cnt) {


//        System.out.println(node + " " + sum + " " + cnt);
        if(cnt == N){
            if(arr[node][1] != 0){
                sum += arr[node][1];
                ans = Math.min(ans, sum);
            }
            return;
        }

        for(int i=1; i<=N; i++){
            if(arr[node][i] != 0 && !visited[i]){
                visited[i] = true;
                sum += arr[node][i];
                dfs(i, sum, cnt+1);
                visited[i] = false;   // 방문 처리 취소
                sum -= arr[node][i];   // 방문 처리 했을 떄 더해준 값도 다시 뺴줘야한다.
            }
        }
    }
}