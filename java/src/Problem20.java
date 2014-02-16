import org.apache.commons.math.util.MathUtils;

import java.math.BigInteger;

/**
 * Created by adam on 2/16/14.
 */
public class Problem20 implements Euler {
    @Override
    public String answer() throws Exception {
        BigInteger b = BigInteger.ONE;
        for(int i = 100; i > 0; i--) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        int sum = 0;
        for(char c : b.toString().toCharArray()) {
            sum+=(c-'0');
        }
        return Integer.toString(sum);
    }
}
