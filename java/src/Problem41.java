import com.google.common.base.Preconditions;

/**
 * Created by adam on 1/10/16.
 */
public class Problem41 implements Euler {
    @Override
    public String answer() throws Exception {
        return Integer.toString(find_largest_pandigital_prime());
    }

    private int find_largest_pandigital_prime() {
        int max = 0;
        for(int i = 1; i < 10000000; i++) {
            if(isPandigitalForN(i, numberOfDigits(i)) && EulerHelper.isPrime(i)) {
                if(i > max) {
                    max = i;
                }
            }
        }
        return max;
    }

    private boolean isPandigitalForN(int number, int n) {
        Preconditions.checkArgument(number > 0);
        Preconditions.checkArgument(n > 0);
        int[] table = new int[n];

        for(char c : Integer.toString(number).toCharArray()) {
            int digit = c - '0';
            if(digit == 0) {
                return false;
            }
            if(digit > table.length) {
                return false;
            }
            table[digit-1]++;
            if(table[digit-1] > 1) {
                return false;
            }
        }
        for(int i = 0; i < table.length; i++) {
            if(table[i] != 1) {
                return false;
            }
        }
        return true;
    }

    private int numberOfDigits(int n) {
        Preconditions.checkArgument(n>0);
        int count = 0;
        while(n > 0) {
            n/=10;
            count++;
        }

        return count;
    }
}
