import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int fib [] = new int[41];
		int ans[][] = new int[41][2];
		fib[0] = 0;
		fib[1] = 1;
		ans[0][0] = 1;
		ans[0][1] = 0;
		ans[1][0] = 0;
		ans[1][1] = 1;
		for (int i = 2; i < 41; i++) {
//			fib[i] = fib[i-1] + fib[i-2];
			ans[i][0] = ans[i-1][0] + ans[i-2][0];
			ans[i][1] = ans[i-1][1] + ans[i-2][1];
//			System.out.println(ans[i][0] + " " +ans[i][1] );
//			System.out.println(ans[i][1]);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			sb.append(ans[m][0] + " " + ans[m][1]  + '\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
//		System.out.println(sb.toString());
	}
}