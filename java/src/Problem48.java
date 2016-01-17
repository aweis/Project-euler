import com.google.common.base.Preconditions;

import java.math.BigInteger;

/**
 * Created by adam on 1/17/16.
 */
public class Problem48 implements Euler {

    @Override
    public String answer() throws Exception {
        String result = selfPowers(1000).toString();
        return result.substring(result.length()-10);
    }

    private BigInteger selfPowers(int n) {
        Preconditions.checkArgument(n>0);
        BigInteger acc = BigInteger.ZERO;
        for(int i = 1; i <= n; i++) {
            acc = acc.add(BigInteger.valueOf(i).pow(i));
        }
        return acc;
    }
}
