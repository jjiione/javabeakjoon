import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
    public Info(int age, String str, int index){
        this.age = age;
        this.str = str;
        this.index = index;
    }
    int age;
    String str;
    int index;

    @Override
    public int compareTo(Info info){
        if(this.age < info.age)
            return -1;
        else if(this.age > info.age)
            return 1;
        else return this.index-info.index;

    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        while(!queue.isEmpty()){
            Info info = queue.poll();
            sb.append(info.age).append(" ").append(info.str).append("\n");
        }
        System.out.println(sb);

    }
}