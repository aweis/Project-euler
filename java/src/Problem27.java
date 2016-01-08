/**
 * Created by adam on 1/7/16.
 */
import com.google.common.math.*;
import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.LinkedList;

public class Problem27 implements Euler {
    public String answer() {
        return Integer.toString(iterate_the_space());
    }

    private int iterate_the_space() {
        int a, b, max_prod = 0, max_so_far = 0;
        for (a = -999; a < 1000; a++) {
            for (b = -999; b < 1000; b++) {
                int length = list_consecutive_primes(a, b).size();
                if (length > max_so_far) {
                    max_so_far = length;
                    //System.out.println("Max so far is: " + max_so_far + ", when a=" + a + ", b=" + b);
                    max_prod = a * b;
                }
            }
        }
        return max_prod;
    }

    private Collection list_consecutive_primes(int a, int b) {
        Collection<Integer> list = new LinkedList<Integer>();
        int counter = 0;
        while(true) {
            int result = quadratic(a, b, counter);
            if(EulerHelper.isPrime(result)) {
                counter++;
                list.add(result);
            } else {
                break;
            }
        }
        return list;
    }

    private int quadratic(int a, int b, int n) {
        Preconditions.checkArgument(Math.abs(a) < 1000, "|a| has to be < 1000");
        Preconditions.checkArgument(Math.abs(b) < 1000, "|b| has to be < 1000");
        return IntMath.checkedAdd(IntMath.pow(n, 2), IntMath.checkedAdd(IntMath.checkedMultiply(a, n), b));
    }
}
