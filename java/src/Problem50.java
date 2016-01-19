import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by adam on 1/18/16.
 */
public class Problem50 implements Euler {
    ArrayList<Integer> primeSet;
    int[] primes;

    public Problem50() {
        this.primes = Ints.toArray(allPrimesLessThanN(1000000));
    }

    @Override
    public String answer() throws Exception {
        int[] solution = sumsOfPrimes(primes, 1000000);

        int longestLength = solution[0];
        int endIndex = solution[1];
        int sum = 0;
        for(int i = endIndex+1-longestLength; i < endIndex+1; i++) {
            sum += primes[i];
        }
        return Integer.toString(sum);
    }

    private int[] sumsOfPrimes(int[] primes, int max) {
        int runningSum = 0;
        int runningLength = 0;
        int longestLengthSoFar = 0;
        int longestLengthEndIndex = 0;
        for(int i = 0; i < primes.length; i++) {
            for(int j = i; j < primes.length; j++) {
                runningSum = primes[j] + runningSum;
                if(runningSum > max) {
                    break;
                }
                if(runningSum < max && EulerHelper.isPrime(runningSum)) {
                    runningLength = j - i + 1;
                }
                if(runningLength > longestLengthSoFar) {
                    longestLengthSoFar = runningLength;
                    longestLengthEndIndex = j;
                }
            }
            runningSum = 0;
            runningLength = 0;
        }
        return Ints.toArray(Lists.newArrayList(longestLengthSoFar, longestLengthEndIndex));
    }

    private ArrayList<Integer> allPrimesLessThanN(int n) {
        ArrayList<Integer> al = Lists.newArrayList();
        for(int i = 1; i < n; i++) {
            if(EulerHelper.isPrime(i)) {
                al.add(i);
            }
        }
        return al;
    }
}
