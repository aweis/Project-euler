import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by adam on 1/8/16.
 */
public class Problem32 implements Euler {
    public String answer() {
       Collection<Integer> collection = find_all_pandigitals();
       int sum = 0;
       for(int elem : collection) {
           sum = IntMath.checkedAdd(elem, sum);
       }
       return Integer.toString(sum);
    }

    private Collection find_all_pandigitals() {
        Set set = new HashSet<Integer>();

        for(int i = 1; i < 10000; i++) {
            for (int j = 1; j < 10000; j++) {
                if(is_pandigital(i, j)) {
                    set.add(i*j);
                }
            }
        }

        return set;
    }

    private boolean is_pandigital(int multiplicand, int multiplier) {
        Preconditions.checkArgument(multiplicand>0);
        Preconditions.checkArgument(multiplier>0);

        String s = (Integer.toString(multiplicand) + Integer.toString(multiplier)
                + Integer.toString(multiplicand*multiplier));
        if(s.contains("0")) {
            return false;
        }

        Boolean[] boolean_arr = new Boolean[9];
        Arrays.fill(boolean_arr, false);

        for(char c : s.toCharArray()) {
            boolean_arr[c-'0'-1] = true;
        }

        Iterable bools = Arrays.asList(boolean_arr);

        boolean all_there = Iterables.all(bools, new Predicate<Boolean>() {
            public boolean apply(Boolean input) {
                return input == true;
            }
        });

        return all_there && (s.length() == 9);
    }
}
