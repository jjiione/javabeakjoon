import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(br.readLine());
			int people[][] = new int[N][2];
			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				people[i][0] = Integer.parseInt(st.nextToken());
				people[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(people, new Comparator<int[]>(){
				@Override
				public int compare(int []o1, int[]o2){
					return o1[0]-o2[0];
				}
			});

			int score = Integer.MAX_VALUE;
			int ans = 0;
			for(int i=0; i<N; i++){
				if(score > people[i][1]){
					ans ++;
					score = people[i][1];
				}
			}

			sb.append(ans).append("\n");
		}

		System.out.println(sb);


	}

}