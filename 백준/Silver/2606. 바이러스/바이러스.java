import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int cnt = 0;
        parent = new int [N+1];
        for(int i=1; i<=N; i++) parent[i] = i;
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
//            System.out.println(Arrays.toString(parent));
        }
        for(int i=2; i<=N; i++){
            if(find(i) == 1){
                cnt++;
//                System.out.println(i + " " + parent[i]);
            }

        }


        System.out.println(cnt);


    }
    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;

        if(x<=y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}