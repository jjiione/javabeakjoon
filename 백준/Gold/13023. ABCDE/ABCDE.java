import jdk.internal.dynalink.beans.StaticClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adjList;
    static boolean [] visited;
    static int N;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        for(int i=0; i<N; i++) adjList[i] = new ArrayList<Integer>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for(int i=0; i<N; i++){
            visited = new boolean[N];
            if(!flag)
                dfs(i, 1);
        }

        if(!flag)
            System.out.println(0);


    }

    private static void dfs(int x,  int cnt) {
        if(cnt == 5){
            System.out.println(1);
            flag = true;
            return;
        }
        visited[x] = true;
        for(int a : adjList[x]){
            if(!visited[a] && !flag){
                dfs(a, cnt+1);
            }
        }
        visited[x] = false;

    }

}