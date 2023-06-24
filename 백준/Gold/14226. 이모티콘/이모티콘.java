import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// bfs를 활용하여 구현
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S =  Integer.parseInt(br.readLine());
		boolean [] visited = new boolean [2002];

		//연산 횟수 오름차순, 이모티콘 수 내림차순, 클립보드 수 내림차순으로 정렬
		PriorityQueue<int[]> queue = new PriorityQueue<>((int[]a, int[]b)->{
				return a[1] - b[1];
		});

		queue.offer(new int[]{1, 0, 0});
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			visited[curr[0]] = true;
			if(curr[0] == S){
				System.out.println(curr[1]);
				break;
			}
			if(curr[0] != curr[2])
				queue.offer(new int[]{curr[0], curr[1] + 1, curr[0]}); // 클립보드에 저장
			if(curr[0] + curr[2] < S * 2 &&  !visited[curr[0] + curr[2]] && curr[2] != 0){
				queue.offer(new int []{curr[0] + curr[2], curr[1] + 1, curr[2]});  //클립보드 붙여넣기
			}
			if(curr[0] -1 >= 0 && visited[curr[0] -1]){
				queue.offer(new int[]{curr[0]-1, curr[1]+1, curr[2]});
			}

		}

	}

}