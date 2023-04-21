import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int tmp;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int [N+1];
		int ans = 0;
		int ansIdx = 0;
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			boolean [] check = new boolean [N+1];
			check[i] = true;
			tmp = 1;
			find(check, i);
			
			if(tmp > ans) {
				ans = tmp;
				ansIdx = i;
			}
			
			ans = Math.max(tmp, ans);
		}
		System.out.println(ansIdx);
	}

	private static void find(boolean[] check, int idx) {
		// TODO Auto-generated method stub
		if(!check[arr[idx]]) {
			check[arr[idx]] = true;
			tmp++;
			find(check, arr[idx]);
		}
	}


}