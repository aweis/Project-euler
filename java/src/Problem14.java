import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by adam on 2/2/14.
 */
public class Problem14 implements Euler{
    int max = 1000000;
    @Override
    public String answer() throws Exception {
        int maxChainSoFar = 0;
        int maxStartNumber = 0;
        for(int curr = 1; curr < max; curr++) {
            int temp = collatz(curr);
            if (temp > maxChainSoFar) {
               //System.out.println(curr + " had a chain of " + temp + " long");
               maxChainSoFar = temp;
               maxStartNumber = curr;
            }
        }
        return Integer.toString(maxStartNumber);
    }
    private int collatz(long n) {
        long start = n;
        int count = 1;
        while(true) {
            //System.out.println(n);
            if(n == 1) {
                //System.out.println("Count: " + count);
                return count;
            } else if(n % 2 == 0) {
                n = n / 2;
            } else if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                System.out.println(n);
                System.err.println("wut. can't math");
                System.exit(-1);
            }
            count++;
        }
    }
}
