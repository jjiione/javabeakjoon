import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N];
        make();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)
                    union(i, j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int first = find(a);
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken())-1;
//            System.out.println(find(tmp));
            if(find(tmp) != first){
                System.out.println("NO");

                return;
            }

        }
        System.out.println("YES");
    }

    static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
    static int find(int a) {
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;

        if(x<=y) parents[y] = x;
        else parents[x] = y;
        return true;
    }

}