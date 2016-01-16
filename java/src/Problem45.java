import com.google.common.base.Preconditions;

import java.math.BigInteger;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * Created by adam on 1/13/16.
 */
public class Problem45 implements Euler {
    public class NumberStore{
        TreeSet<BigInteger> set;
        Function<BigInteger,BigInteger> f;
        public NumberStore(Function<BigInteger,BigInteger> f) {
            this.set = new TreeSet<BigInteger>();
            this.f = f;
            set.add(f.apply(BigInteger.ONE)); // Get the stores set up with their first element
        }

        public BigInteger getNth(BigInteger n) {
            return f.apply(n);
        }

        public boolean contains(BigInteger n) {
            computeUpTo(n);
            return set.contains(n);
        }

        private void computeUpTo(BigInteger n) {
            Preconditions.checkArgument(n.compareTo(BigInteger.ZERO) > 0);
            while(set.last().compareTo(n) < 0) {
                set.add(getNth(BigInteger.valueOf(set.size()).add(BigInteger.ONE)));
            }
        }
    }

    interface storeLambda {
        BigInteger run(BigInteger input);
    }
    public void runCalc(storeLambda fn) {

    }

    @Override
    public String answer() throws Exception {
        NumberStore triangleStore = new NumberStore(n -> n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
        NumberStore pentagonalStore = new NumberStore(n -> n.multiply(BigInteger.valueOf(3).multiply(n).subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
        NumberStore hexagonalStore = new NumberStore(n -> n.multiply(BigInteger.valueOf(2).multiply(n).subtract(BigInteger.ONE)));

        int counter = 286;
        while(true) {
            BigInteger n = triangleStore.getNth(BigInteger.valueOf(counter));
            if(pentagonalStore.contains(n) && hexagonalStore.contains(n)) {
                return n.toString();
            }
            counter++;
        }
    }
}
