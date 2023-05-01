import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 14698 전생했더니 슬라임 연구자였던 건에 대하여
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 1) {
				br.readLine();
				sb.append(1).append("\n");
				continue;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger ans = BigInteger.valueOf(1);
			PriorityQueue<BigInteger> queue = new PriorityQueue<>();
			while(st.hasMoreTokens()) {
				BigInteger num = BigInteger.valueOf(Long.parseLong(st.nextToken()));
				queue.add(num);
			}
			while(queue.size() > 1) {
				BigInteger tmp = queue.poll().multiply(queue.poll()) ;
				ans = ans.multiply(tmp) ;
				queue.add(tmp);
//				System.out.println(tmp + " " + ans);
			}
			BigInteger mod = BigInteger.valueOf(1000000007);
			sb.append(ans.remainder(mod)).append("\n");
		}
		System.out.println(sb.toString());
	}

}