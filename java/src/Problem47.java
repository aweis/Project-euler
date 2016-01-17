import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adam on 1/16/16.
 */
public class Problem47 implements Euler {
    @Override
    public String answer() throws Exception {
        int min = Integer.MAX_VALUE;
        for(int number : findConsecutiveDistinct4Primes()) {
            if (number < min) {
                min = number;
            }
        }
        return Integer.toString(min);
    }

    private Set<Integer> findConsecutiveDistinct4Primes() {
        int n = 4;
        int first = 2;
        int second = 3;
        int third = 4;
        int fourth = 5;
        int index = 0;
        while(true) {
            if(primeFactors(first+index).size() == n
                    && primeFactors(second+index).size() == n
                    && primeFactors(third+index).size() == n
                    && primeFactors(fourth+index).size() == n) {
                return Sets.newHashSet(first+index, second+index, third+index, fourth+index);
            }
            index++;
        }
    }

    /* returns the set of factors that are not 1 or n */
    private Set<Integer> primeFactors(int n) {
        Preconditions.checkArgument(n > 0);

        int removedFactors = n;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0) {
                while(removedFactors%i==0) {
                    removedFactors /= i;
                }
                if(EulerHelper.isPrime(n/i)) {
                    set.add(n / i);
                }
                if(EulerHelper.isPrime(i)) {
                    set.add(i);
                }
            }
        }
        return set;
    }
}
