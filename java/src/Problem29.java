import com.google.common.math.LongMath;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by adam on 1/7/16.
 */
public class Problem29 implements Euler {
    public String answer() {
        return Integer.toString(generate_powers(100,100).size());
    }

    private Collection generate_powers(int a_ceil, int b_ceil) {
        Set set = new TreeSet<BigInteger>();
        for(int a = 2; a <= a_ceil; a++) {
           for(int b = 2; b <= b_ceil; b++) {
               BigInteger big_a = new BigInteger(Integer.toString(a));
               set.add(big_a.pow(b));
           }
        }
        return set;
    }
}
