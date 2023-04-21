import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			priorityQueue.offer(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		
		while(priorityQueue.size() != 1) {
			int tmp = priorityQueue.poll() + priorityQueue.poll();
			sum += tmp;
			priorityQueue.offer(tmp);
		}
		
		System.out.println(sum);
	}
}