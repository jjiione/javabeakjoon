import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> strMap = new TreeMap<>();
		TreeMap<Integer, String> numMap = new TreeMap<>();
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			strMap.put(str, i);
			numMap.put(i, str);
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<M; i++){
			String input = br.readLine();
			if(input.charAt(0) - '0' > 0 && input.charAt(0) - '0' <= 9){
				sb.append(numMap.get(Integer.parseInt(input))).append("\n");
			}else
				sb.append(strMap.get(input)).append("\n");
		}

		System.out.println(sb);



	}


}