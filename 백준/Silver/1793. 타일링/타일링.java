import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger[] memoArray = null;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        memoArray = new BigInteger[251];
        memoArray[0] = BigInteger.valueOf(1);
        memoArray[1] = BigInteger.valueOf(1);
        while(scan.hasNextInt()) {
            int inputData = Integer.parseInt(scan.nextLine().trim());
            
            for(int i=0; i <= inputData; i++) {
                if(memoArray[i] != null) {
                    continue ;
                }
                
                BigInteger mul = memoArray[i-2].multiply(BigInteger.valueOf(2));
                BigInteger data = memoArray[i-1];
                memoArray[i] = data.add(mul);
            }
            
            System.out.println(memoArray[inputData]);
        }
    }
}