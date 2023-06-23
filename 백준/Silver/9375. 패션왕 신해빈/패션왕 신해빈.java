import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int number[];
	static boolean selected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++){
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			HashMap<String, Integer> map = new HashMap<>();

			if(N == 0){
				sb.append("0\n");
				continue;
			}

			for(int i=0; i<N; i++){
				String [] str = br.readLine().split(" ");
				if(map.containsKey(str[1])){
					map.put(str[1], map.get(str[1]) + 1);
				}else{
					map.put(str[1], 1);
				}
			}

			for(int i : map.values()){
				ans *= i+1;
			}

			sb.append(ans-1).append("\n");
		}
		System.out.println(sb);

	}

}