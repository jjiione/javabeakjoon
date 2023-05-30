import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.nextToken().equals("I")){
					int num = Integer.parseInt(st.nextToken());
					if(map.containsKey(num))
						map.put(num, map.get(num)+1);
					else
						map.put(num, 1);
				}else{
					int num = Integer.parseInt(st.nextToken());
					if(!map.isEmpty()){
						int tgt = ( num==1 ? map.lastKey() : map.firstKey() );

						int cnt = map.put(tgt, map.get(tgt)-1);
//						System.out.println(tgt + " " + cnt);  previous value 반환
						if(cnt==1) map.remove(tgt);
					}

				}
			}
			if(map.isEmpty()){
				sb.append("EMPTY\n");
			}else{
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);


	}


}