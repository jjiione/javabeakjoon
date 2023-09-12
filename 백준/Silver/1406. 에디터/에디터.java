import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<>();
        for(char ch: s.toCharArray()){
            left.push(ch);
        }
        int n=Integer.parseInt(br.readLine());
        while(n-->0){
            String[] line=br.readLine().split(" ");
            char h=line[0].charAt(0);
            if (h=='L'){
                if (!left.isEmpty()){
                    right.push(left.pop());
                }
            }
            else if (h=='D'){
                if (!right.isEmpty()){
                    left.push(right.pop());
                }
            }
            else if (h=='B'){
                if (!left.isEmpty()){
                    left.pop();
                }
            }
            else if (h=='P'){
                left.push(line[1].charAt(0));
            }
        }
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        StringBuilder sb=new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}