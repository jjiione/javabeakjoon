import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger[] dp = new BigInteger [251];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		for(int i=3; i<251; i++) {
			BigInteger tmp =dp[i-2].multiply(new BigInteger("2"));
			tmp = tmp.add(dp[i-1]);
			
			dp[i] = tmp;
		}

		String str = null;
		while((str = br.readLine()) != null) {
//			System.out.println(dp[Integer.parseInt(str)]);
			sw.write(dp[Integer.parseInt(str)].toString());
			sw.newLine();
		}
		sw.flush();
	}

}