import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine()); 
    int i = 2;
    int[] box = new int[1001];
    box[0] = 1;
    box[1] = 3;

    if (num == 1){
      System.out.println(box[0]);
    }
    else{
      while(i != num){
        box[i] = box[i-1] + box[i-2]*2;
        box[i] %= 10007;
        i++;
      }
      System.out.println(box[i-1]);
    }

  }
}