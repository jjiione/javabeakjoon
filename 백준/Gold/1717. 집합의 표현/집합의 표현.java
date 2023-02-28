import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 0){
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }else{
                if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.println(sb);

    }
    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;
        if(a<=b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

}