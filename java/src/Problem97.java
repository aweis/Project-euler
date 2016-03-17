import java.math.BigInteger;

/**
 * Created by adam on 3/17/16.
 */
public class Problem97 implements Euler {
    @Override
    public String answer() throws Exception {
        BigInteger b = BigInteger.valueOf(1).add(BigInteger.valueOf(28433).multiply(BigInteger.valueOf(2).pow(7830457)));
        String num = b.toString();
        String last10 = num.substring(num.length()-10);
        return last10;
    }
}
