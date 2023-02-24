import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 암호 만들기
// L과 C의 범위가 15까지이므로 단순 조합으로 풀면 최대 경우  7C15
// 일단 모음 기준이 중요할 것 같은데 
// 자음만으로 일단 
public class Main {
	
	static int L, C;
	static char[]input;
	static char[]selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String str = br.readLine().replace(" ", "");
		input = new char[C];
		selected = new char[L];
		
		for(int i=0; i<str.length(); i++)
			input[i] =  str.charAt(i);
		Arrays.sort(input);
		
		combination(0, 0);
		System.out.println(sb.toString());
		
	}
	
	
	private static void combination(int start, int cnt) {
		if(cnt>=L) {

			int vowCnt = 0;
			for(char ch : selected) {
				if(ch == 'a' || ch == 'e' || ch=='i' || ch=='o' || ch=='u' )
					vowCnt++;
			}
			if(vowCnt > 0 && vowCnt <=L-2) {
				for(char ch : selected)
					sb.append(ch);
				sb.append("\n");
			}
			
			return;
		}
		for(int i=start; i<input.length; i++) {
			selected[cnt] = input[i];
			combination(i+1, cnt+1);
			

		}
		
	}

}