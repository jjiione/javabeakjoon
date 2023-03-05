import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int input[];
    static int number[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        Arrays.sort(input);
        number = new int[M];
        combination(0, 0);
        System.out.println(sb);
    }

    private static void combination(int cnt, int start) {
        if(cnt== M){
            for (int i = 0; i <M ; i++) {
                sb.append(number[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            number[cnt] = input[i];
            combination(cnt+1, i+1);
        }
    }

}