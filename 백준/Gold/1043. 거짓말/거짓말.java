import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import javax.management.Query;
import javax.swing.plaf.synth.SynthSeparatorUI;

// 거짓말
public class Main {
	static int N, M;
	static List<Integer> pre;
	static int [][]graph;
	static boolean people[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = 0;
        
        List<Integer>[] party = new ArrayList[M];  
        graph = new int[N+1][N+1];    // 사람을 그래프로 만든다.

        people = new boolean[N+1];
        pre = new ArrayList<>();   // 시작부터 거짓말쟁이라고 알고 있는 사람들 리스트
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        if(p == 0){  // 진실을 아는 사람이 없으면 모든 파티에서 거짓말 가능
            System.out.println(M);
            return;
        }

        for(int i=0; i<p; i++){
            pre.add(Integer.parseInt(st.nextToken()));   // 진실을 말해야함
        }
        
//        System.out.println(pre.toString());
        
        for(int i=0; i<M; i++){
        	party[i] = new ArrayList<>();
        	st = new StringTokenizer(br.readLine());
        	int t = Integer.parseInt(st.nextToken());
//        	System.out.println(t);
        	for(int j=0; j<t; j++) {
        		party[i].add(Integer.parseInt(st.nextToken()));
        	}
//        	 System.out.println(party[i].toString());
        }
        
        
        // 파티 참석 명단을 가지고 그래프 구성하기
        for(List<Integer> list : party) {
        	for(int i=0; i<list.size(); i++) {
        		for(int j=i; j<list.size(); j++) {
        			graph[list.get(i)][list.get(j)] = 1;   // 양방향  그래프 연결 시키기
        			graph[list.get(j)][list.get(i)] = 1; 
        		}
        	}
        }
        
        
        
        // 진실을 알고 있는 사람 찾기
        bfs();
        
//        System.out.print("know : ");
//        for(int i=1; i<=N; i++) {
//        	if(people[i])System.out.print(i + " ");
//        }
//        System.out.println();
        
     // 거짓말 가능 파티 찾기
        for(List<Integer> list : party) {
//        	System.out.println("party : " + list.toString());
        	boolean flag = true;
        	for(int i=0; i<list.size(); i++) {
        		if(people[list.get(i)]) {
        			flag = false; // 파티에 진실을 아는 사람이 있다면 거짓말 못함
        			break;
        		}
        		
        	}
        	if(flag) {
        		ans++;
        	}
        }
        
         
        
        
//        System.out.println(people.toString());
        System.out.println(ans);

    }

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i: pre) {
			queue.offer(i);
			people[i] = true;
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				for(int j =1; j<=N; j++) {
//					System.out.println(j);
					if(graph[curr][j] == 1 && !people[j]) {
						queue.offer(j);
						people[j] = true;
					}
				}
			}
		}
		
	}
}