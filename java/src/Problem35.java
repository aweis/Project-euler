import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adam on 1/9/16.
 */
public class Problem35 implements Euler {

    @Override
    public String answer() throws Exception {
        int counter = 0;
        for(int i = 2; i < 1000000; i++) {
            if(is_circular_prime(i)) {
                counter++;
            }
        }
        return Integer.toString(counter);
    }

    private boolean is_circular_prime(int n) {
        Preconditions.checkArgument(n > 1);
        return all_prime(gen_rotations(n));
    }

    private Collection<Integer> gen_rotations(int n) {
        return gen_rotations_h(Integer.toString(n), "", new ArrayList<String>());
    }

    private Collection<Integer> gen_rotations_h(String s1, String s2, Collection<String> acc) {
        if(s1.length() == 0) {
            return acc.stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        }
        acc.add(s1+s2);
        return gen_rotations_h(s1.substring(1), s2+s1.charAt(0), acc);
    }

    private boolean all_prime(Collection<Integer> c) {
        for(int elem : c) {
            if(!EulerHelper.isPrime(elem)) {
                return false;
            }
        }
        return true;
    }
}
