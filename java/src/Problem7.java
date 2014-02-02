import java.util.TreeSet;

/**
 * Created by adam on 2/1/14.
 */
public class Problem7 implements Euler {
    final int max = 10001;
    TreeSet<Integer> knownPrimes;
    public Problem7() {
        knownPrimes = new TreeSet<Integer>();
        knownPrimes.add(2);
        knownPrimes.add(3);
    }
    /** Problem 7
     *
      * @return the answer
     */
    public String answer() {
        int i = knownPrimes.last()+1;
        while(true) {
            if (notInKnownPrimes(i)) {
                knownPrimes.add(i);
            }
            i++;
            if (knownPrimes.size() == max) {
                return Integer.toString(knownPrimes.last());
            }
        }
    }

    private boolean notInKnownPrimes(int test) {
        for(int x : knownPrimes) {
            if (test % x == 0) {
                return false;
            }
        }
        return true;
    }
}
