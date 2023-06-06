import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Place implements Comparable<Place> {
	public Place(int r, int c, int score){
		this.r = r;
		this.c = c;
		this.score =score;
	}
	int score;
	int r;
	int c;

	@Override
	public int compareTo(Place o2){
		if(this.score == o2.score){
			if(this.r == o2.r){
				return this.c - o2.c;
			}else{
				return this.r - o2.r;
			}
		}
		return o2.score - this.score;
	}

	@Override
	public String toString() {
		return "Place{" +
				"score=" + score +
				", r=" + r +
				", c=" + c +
				'}';
	}
}

public class Main {
	static int N, stdNum;
	static int[][] stdLike;
	static int [] order;
	static int [][] arr;
	static int [] dr = {1, 0 , -1, 0};
	static int [] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stdNum = N*N;
		stdLike = new int[stdNum+1][4];
		order = new int[stdNum+1];
		arr = new int [N][N];

		for(int i=1; i<=stdNum; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			order[i] = num;
			for(int j=0; j<4; j++)
				stdLike[num][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<=stdNum; i++){
			firstRule(order[i]);
		}

//		for(int i=0;i<N; i++){
//			for(int j=0; j<N; j++){
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		int ans = 0;

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				int score = 0;
				int student = arr[i][j];
				for(int k=0; k<4; k++){
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					for(int a=0; a<4; a++){
						if(arr[nr][nc] == stdLike[student][a])
							score++;
					}
				}
				if(score == 0)
					continue;
				ans += Math.pow(10, score-1);
			}
		}

		System.out.println(ans);




	}

	private static void firstRule(int student) {
		PriorityQueue<Place> queue = new PriorityQueue();
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(arr[i][j] != 0)
					continue;
				int score = 0;
				for(int k=0; k<4; k++){
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					for(int a=0; a<4; a++){
						if(arr[nr][nc] == stdLike[student][a])
							score++;
					}

				}
				queue.add(new Place(i, j, score));
			}
		}

		ArrayList<Place> list = new ArrayList<>();
		Place place = queue.peek();
//		System.out.println(place + " " + queue.size());
		while(!queue.isEmpty() && place.score == queue.peek().score){
			list.add(queue.poll());
		}

//		System.out.println(list.toString());

		if(list.size() == 1)
			arr[list.get(0).r][list.get(0).c] = student;
		else 
			SecondRule(student, list);

	}

	private static void SecondRule(int student, ArrayList<Place> list) {
//		System.out.println(list.toString());
		PriorityQueue<Place> queue = new PriorityQueue<>();
		for(int i=0; i<list.size(); i++){
			int score = 0;
			for(int j=0; j<4; j++){
				int nr = list.get(i).r + dr[j];
				int nc = list.get(i).c + dc[j];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if(arr[nr][nc] == 0)
					score++;
			}
			queue.add(new Place(list.get(i).r, list.get(i).c, score));
		}


		Place place = queue.peek();

		arr[place.r][place.c] = student;


	}



}