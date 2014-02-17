import java.math.BigInteger;

/**
 * Created by adam on 2/17/14.
 */
public class Problem25 implements Euler {
    @Override
    public String answer() throws Exception {
        BigInteger even = BigInteger.ONE;
        BigInteger odd = BigInteger.ONE;
        int count = 3;
        BigInteger current;
        while(true) {
            if(count % 2 == 0) {
                even = even.add(odd);
                current = even;
            } else {
                odd = odd.add(even);
                current = odd;
            }
            if(current.toString().length() == 1000) {
                return Integer.toString(count);
            }
            count++;
        }
    }
}
