import java.io.*;
import java.util.*;

// 웅덩이 정보를 입력받는다
// 웅덩이끼리 겹치는 경우는 없다.
// 웅덩이를 정렬한다.
// 웅덩이 시작점부터 널빤지로 덮는다. 마지막으로 덮은 널빤지 좌표를 업데이트한다.

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());


		PriorityQueue<int []> queue = new PriorityQueue<>((a, b)-> a[0]-b[0]);

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			queue.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		int stick = queue.peek()[0]-1;  // 널빤지 끝 지점
		int ans = 0;  // 필요한 널빤지의 수

		while(!queue.isEmpty()){
			int [] curr = queue.poll();
			if(curr[0] <= stick){  // 이전에 깔아둔 널빤지가 웅덩이까지 있을 때
				curr[0] = stick+1;
			}
			int size = curr[1] - curr[0] ;  // 채워야하는 웅덩이 크기
			int cnt = (int) Math.ceil((double)size/(double)L);
			ans += cnt;
			stick = curr[0] +  cnt*L -1;
//			System.out.println(size + " " + cnt + " " + stick);

		}

		System.out.println(ans);



	}
}
