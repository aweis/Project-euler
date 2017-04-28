import com.google.common.math.LongMath;

import java.math.BigInteger;

/**
 * Created by adam on 3/10/16.
 */
public class Problem53 implements Euler {

    @Override
    public String answer() throws Exception {
        int count = 0;
        for(int n = 1; n <= 100; n++) {
            for(int r = 1; r <= n; r++) {
                BigInteger ret = binomial(n, r);
                if(ret.compareTo(BigInteger.valueOf(1000000)) > 0) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    BigInteger binomial(int n, int r) {
        BigInteger ret = BigInteger.ONE;
        for(int k = 0; k < r; k++) {
            ret = ret.multiply(BigInteger.valueOf(n-k)).divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }
}
