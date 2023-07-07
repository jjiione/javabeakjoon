import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Room implements Comparable<Room>{
    public Room(int start, int end){
        this.start = start;
        this.end = end;
    }
    int start;
    int end;

    @Override
    public int compareTo(Room o){
        if(this.start == o.start)
            return this.end - o.end;

        else return this.start-o.start;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Room[] rooms  = new Room[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(start, end);
        }

        Arrays.sort(rooms);
        queue.add(rooms[0].end);
        for(int i=1; i<N; i++){
            if(rooms[i].start >= queue.peek())
                queue.poll();
            queue.offer(rooms[i].end);
        }

        System.out.println(queue.size());
    }
}