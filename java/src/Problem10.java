import java.util.TreeSet;

/**
 * Created by adam on 2/1/14.
 */
public class Problem10 implements Euler {
    final int max = 2000000;
    @Override
    public String answer() {
        long sum = 0;
        for(int i = 2; i < max; i++) {
            if (isPrime(i)) {
               sum+=i;
            }
        }
        return Long.toString(sum);
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            double max_divisor = Math.sqrt(n);
            int divisor = 5;
            while (divisor <= max_divisor) {
                if (n % divisor == 0 || n % (divisor + 2) == 0) {
                    return false;
                }
                divisor += 6;
            }
            return true;
        }
    }
}
