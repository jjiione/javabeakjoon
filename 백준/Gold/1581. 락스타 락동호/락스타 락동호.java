import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ff = Integer.parseInt(st.nextToken());
		int fs = Integer.parseInt(st.nextToken());
		int sf = Integer.parseInt(st.nextToken());
		int ss = Integer.parseInt(st.nextToken());
		
		if(ff + fs == 0) { // 빠르게 시작하는 노래 없음
			if(sf != 0) {
				System.out.println(ss + 1);
			}else {
				System.out.println(ss);
			}
		}else {  // 빠르게 시작하는 노래 있음
			int recursive = Math.min(fs, sf);
			if(fs + sf == 0)  // 순환 없을 때
				System.out.println(ff);  // 빠른 노래 먼저 시작 + ff도 0인 경우는 이미 앞에서 조건으로 걸러짐
			else {
				if(recursive == 0) {
					if(fs == 0) {  // ff 무조건 존재, sf도 존재
						System.out.println(ff);	
					}else { // sf 존재 x
						System.out.println(ff + ss + 1);
						
					}
				}else {
					if(fs > sf)
						System.out.println(ff + ss + 2*(recursive)+1);
					else
						System.out.println(ff + ss + 2*(recursive));
				}
		
			}
		}
	}

}