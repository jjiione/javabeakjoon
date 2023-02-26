import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int [N][N];
        for(int i=0; i<N; i++){
            String str[] = br.readLine().split("");
            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(str[j]);
        }

        recursive(0, 0, N);

        System.out.println(sb.toString());

    }

    private static void recursive(int r, int c, int n) {
        if(n <= 1){
            sb.append(arr[r][c]);
            return;
        }

        int check = arr[r][c];
        boolean flag = true;
        for(int i=r; i<r+n; i++){
            for(int j=c; j<c+n; j++){
                if(check != arr[i][j]){
                    sb.append("(");
                    recursive(r,c,n/2);
                    recursive(r,c+n/2, n/2);
                    recursive(r+n/2, c, n/2);
                    recursive(r+n/2, c+n/2, n/2);
                    flag = false;
                    sb.append(")");
                    return;
                }
            }
        }
        if (flag)
            sb.append(check);


    }
}