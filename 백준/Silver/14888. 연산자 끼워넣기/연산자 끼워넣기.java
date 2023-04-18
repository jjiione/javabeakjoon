import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] number;
	static ArrayList<Character> arr = new ArrayList<>();
	static int plus, minus, mul, div;
	static boolean isSelected[];
	static char[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int [N];
		result = new char[N-1];
		isSelected = new boolean[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<plus; i++) 
			arr.add('+');
		for(int i=0; i<minus; i++) 
			arr.add('-');
		for(int i=0; i<mul; i++) 
			arr.add('*');
		for(int i=0; i<div; i++) 
			arr.add('/');
		
		
		permutaion(0);
		
		System.out.println(max);
		System.out.println(min);
		
		
	}
	private static void permutaion(int cnt) {
		if(cnt >= N-1) {
			int tmp = number[0];
		
			for(int i=0; i<N-1; i++) {
				if(result[i] == '+') {
					tmp += number[i+1];
				}else if(result[i] == '-') {
					tmp -= number[i+1];
				}
				else if(result[i] == '*') {
					tmp *= number[i+1];
				}
				else {
					tmp /= number[i+1];
				}
			}
			min = Math.min(min, tmp);
			max = Math.max(max, tmp);
			
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				result[cnt] = arr.get(i);
				permutaion(cnt+1);
				isSelected[i] = false;
			}
		}
		
		
		
	}

}