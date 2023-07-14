import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        if(N == 1){
            System.out.println(1);
        }else if(N == 26){
            System.out.println(str.length());
        }else{
            int front= 0;
            int rear = 1;
            int ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put(str.charAt(0), 1);
            while(rear < str.length()){
                if(map.size() < N){   // 새로운 알파벳 더 추가 가능하므로 rear 옮겨서 탐색
                    if(map.containsKey(str.charAt(rear))){
                        map.put(str.charAt(rear), map.get(str.charAt(rear))+1);
                    }else{
                        map.put(str.charAt(rear), 1);
                    }
                    rear++;
                }else{  // 새로운 알파벳 더 추가 불가능
                    ans = Math.max(ans,  rear-front);
                    if(map.containsKey(str.charAt(rear))){
                        map.put(str.charAt(rear), map.get(str.charAt(rear))+1);
                        rear++;
                    }else{
                        if(map.get(str.charAt(front)) > 1){
                            map.put(str.charAt(front), map.get(str.charAt(front))-1);
                        }else{
                            map.remove(str.charAt(front));
                        }
                        front++;
                    }
                }
//                System.out.println(front + " " + rear);
            }
            ans =Math.max(ans, rear-front);
            System.out.println(ans);
        }

    }
}