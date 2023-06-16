import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int [N][2];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a<b){
				arr[i][0] = a;
				arr[i][1] = b;
			}else{
				arr[i][0] = b;
				arr[i][1] = a;
			}

		}

		Arrays.sort(arr, (int [] o1, int[] o2)->{
			if(o1[0] == o2[0])
				return o1[1]-o2[1];
			else
				return o1[0] - o2[0];
		});

		int start = arr[0][0];
		int end = arr[0][1];
		int ans = 0;
		for(int i=1; i<N; i++){
			int currStart = arr[i][0];
			int currEnd = arr[i][1];

			if(end < currStart){  // 선분이 끊어진 경우
				ans += end - start;
				start = currStart;
				end = currEnd;
			}else{
				end = Math.max(end, currEnd);
			}
		}
		ans += end - start;
		System.out.println(ans);

	}

}