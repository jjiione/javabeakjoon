import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queue2 = new PriorityQueue<>();
		int cnt = 0;
		boolean flag = false;

		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp > 0) {
				queue1.add(tmp);
			}else if(tmp<0) {
				queue2.add(tmp);
			}else
				flag = true;
		}
		
		while(queue1.size() > 1) {
			int a = queue1.poll();
			int b = queue1.poll();
			cnt += Math.max(a*b, a+b);
		}
		
		if(!queue1.isEmpty())
			cnt += queue1.poll();
		
		while(queue2.size() > 1) {
			int a = queue2.poll();
			int b = queue2.poll();
			cnt += Math.max(a*b, a+b);
		}
		
		if(!queue2.isEmpty()) {
			if(!flag)cnt += queue2.poll();
		}
			
		
		System.out.println(cnt);
		
		
		
		
	}

}