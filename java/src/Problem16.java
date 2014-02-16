import java.math.BigInteger;

/**
 * Created by adam on 2/16/14.
 */
public class Problem16 implements Euler {
    @Override
    public String answer() throws Exception {
        int sum = 0;
        BigInteger b = BigInteger.valueOf(2).pow(1000);
        for(char c : b.toString().toCharArray()) {
            int num = c - '0';
            sum+=num;
        }
        return Integer.toString(sum);
    }
}
