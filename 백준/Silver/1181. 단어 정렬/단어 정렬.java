import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		TreeSet<String> set = new TreeSet<>();

		for(int i=0; i<N; i++){
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>(set);


		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()){
					return o1.length() - o2.length();
				}else{
					return o1.compareTo(o2);
				}
			}
		});

		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb);

	}

}