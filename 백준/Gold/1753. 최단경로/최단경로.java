import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine())-1;

//        int[][] adjMatrix = new int[V][V];
        ArrayList<int[]> adjMatrix [] = new ArrayList[V];
        for(int i=0; i<V; i++) adjMatrix[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            adjMatrix[a].add(new int[]{b, w});
        }

        final int INF = Integer.MAX_VALUE;
        int[] distance = new int[V];   // 출발 정점에서 자신까지 오는 최소 비용

        boolean[] visited = new boolean[V];   // 경유지로 고려된 정점 여부

        Arrays.fill(distance, INF);  // 최소값 갱신 로직을 반영해야하므로 큰 값으로 초기화
        distance[start] = 0;

        int min, current;
        for (int c = 0; c < V; c++) {
            // step 1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
            current = -1;
            min = INF;

            for (int i = 0; i < V; i++) {
                if (!visited[i] && min > distance[i]) {
                    min = distance[i];
                    current = i;
                }
            }

            if (current == -1) break;
            visited[current] = true;


            // step2 : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 인접 정점과의 비용 최소값 갱신
            for (int[]j : adjMatrix[current]) {
                if (!visited[j[0]] && j[1] != 0 &&
                        distance[j[0]] > (min + j[1])) {
                    distance[j[0]] = min + j[1];
                }
            }

        }

        for(int i =0; i<distance.length; i++){
            if(distance[i] == INF){
                sb.append("INF\n");
            }
            else sb.append(distance[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}