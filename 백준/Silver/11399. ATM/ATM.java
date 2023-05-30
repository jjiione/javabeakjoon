import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int ans = 0;
		int sum = 0;
		StringTokenizer st= new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			queue.add(Integer.parseInt(st.nextToken()));
		}
		while(!queue.isEmpty()){
			sum += queue.poll();
			ans+=sum;

		}
		System.out.println(ans);
	}


}