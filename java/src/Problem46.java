import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by adam on 1/16/16.
 */
public class Problem46 implements Euler {

    TreeSet<Integer> primesLessThanN(int n, TreeSet<Integer> prev) {
        Preconditions.checkArgument(n > 0);
        TreeSet<Integer> ts = new TreeSet<Integer>(prev);
        for(int i = n-1; i > ts.last(); i--) {
            if(EulerHelper.isPrime(i)) ts.add(i);
        }
        return ts;
    }

    @Override
    public String answer() throws Exception {
        TreeSet<Integer> s = new TreeSet<Integer>();
        s.add(2); s.add(3);
        for(int i = 5; i <10000; i+=2) {
            if(EulerHelper.isPrime(i)) {
                s.add(i);
            }
            else {
                boolean found = false;
                s = primesLessThanN(i, s);
                for(int prime : s) {
                    int leftover = i - prime;
                    int square = leftover/2;
                    if((Math.sqrt(square) == Math.floor(Math.sqrt(square))) &&
                            Math.pow(Math.sqrt(square), 2) * 2  == (i - prime)) {
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    return Integer.toString(i);
                }
            }
        }
        return null;
    }
}
