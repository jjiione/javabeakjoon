import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> {
			if(a[1] != b[1]){
				return a[1] - b[1];
			}
			else{
				return a[0] - b[0];
			}
		});
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		while(!queue.isEmpty()){
			int [] curr = queue.poll();
			sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
		}

		System.out.println(sb);

	}

}