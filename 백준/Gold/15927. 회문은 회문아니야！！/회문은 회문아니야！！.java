import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 이 문제의 핵심은 다음과 같다
// 1. 회문이 아니면 전체 길이가 답
// 2. 회문이 이라면
// 2-1. 회문이 모두 같은 숫자로 되어 있으면 -1
// 2-2 길이 -1
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		String str = br.readLine();
		
		Set<Character> set = new HashSet<Character>();
		boolean flag = true;
		for(int i=0; i<=str.length()/2; i++) {
			set.add(str.charAt(i));
			set.add(str.charAt(str.length()-1-i));
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				continue;
			}else {
//				System.out.println("아님" + i + " " + str.charAt(i));
				flag = false;
				break;
			}
		}
		if(flag) {
			if(set.size() == 1 || str.length() == 1) {
				System.out.println(-1);
			}else {
				System.out.println(str.length()-1);
			}
		}else {
			System.out.println(str.length());
		}
		
	}

}