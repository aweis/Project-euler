import java.util.Collection;
import java.util.TreeSet;
import java.util.Set;

/**
 * Created by adam on 2/1/14.
 */
public class Problem5 {
    /** Returns the answer
     *
     * @return the answer
     */
    public String answer() {
        final int max = 20;
        final int min = 2;
        int i = max;
        while (true) {
            if (isDivisible(i, min, max)) {
                return Integer.toString(i);
            }
            i++;
        }
    }

    private boolean isDivisible(int input, int min, int max) {
        for(int i = min; i <= max; i++) {
            if (input % i != 0) {
                return false;
            }
        }
        return true;
    }
}
