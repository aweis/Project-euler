/**
 * Created by adam on 2/15/14.
 */
import org.apache.commons.math.util.MathUtils;

public class Problem15 implements Euler {
    @Override
    public String answer() throws Exception {
        return Long.toString(MathUtils.binomialCoefficient(40,20));
    }
}
