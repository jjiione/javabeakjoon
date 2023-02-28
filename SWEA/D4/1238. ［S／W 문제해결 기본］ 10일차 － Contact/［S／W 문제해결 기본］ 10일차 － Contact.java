import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Integer>[] list = new ArrayList[101];
    static PriorityQueue<int[]> priorityQueue;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t =1; t<=10; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[1]==o1[1]){
                        return o2[0]-o1[0];
                    }
                    else return o2[1]-o1[1];
                }
            });
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];

            for(int i=1; i<=100; i++) list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));


            bfs(start);

            sb.append("#").append(t).append(" ").append(priorityQueue.peek()[0]).append("\n");

        }
        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start,0});
        priorityQueue.offer(new int[]{start,0});
        visited[start] = true;
        while(!queue.isEmpty()){
            int[]curr = queue.poll();
//            System.out.println(list[curr[0]]);
            for(Integer node : list[curr[0]]){
                if(!visited[node]){
                    queue.offer(new int[]{node, curr[1]+1});
                    visited[node] = true;
                    priorityQueue.offer(new int[]{node, curr[1]+1});
                }
            }
        }

    }
}