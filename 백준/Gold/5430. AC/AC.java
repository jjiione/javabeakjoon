import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            String rule = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine().replace("[", "").replace("]", "");
            StringTokenizer st = new StringTokenizer(input, ",");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean flag = false;
            for(int i=0; i<rule.length(); i++){
                char c = rule.charAt(i);
                if(c == 'R'){
                    isReverse = !isReverse;
                }else{
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        flag = true;
                        break;
                    }else{
                        if(!isReverse){
                            deque.pollFirst();
                        }else{
                            deque.pollLast();
                        }
                    }
                }

            }
            if(!flag){
                sb.append("[");
                if(!isReverse){
                    while(deque.size() > 1){
                        sb.append(deque.pollFirst()).append(",");
                    }
                }else{
                    while(deque.size() > 1){
                        sb.append(deque.pollLast()).append(",");
                    }
                }

                if(deque.size() != 0){
                    sb.append(deque.pollLast());
                }

                sb.append("]\n");
            }


        }
        System.out.println(sb.toString());
    }
}