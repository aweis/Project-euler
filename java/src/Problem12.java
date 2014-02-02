import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 2/2/14.
 */
public class Problem12 implements Euler {
    final int max = 500;
    @Override
    public String answer() throws Exception{
        int triangle = 0;
        int count = 1;
        while(true) {
            triangle += count;
            count++;
            int factors = countFactors(triangle);
            if (factors > max) {
                break;
            }
            if (factors > 500) {
                break;
            }
        }
        return Integer.toString(triangle);
    }

    private int countFactors(int n) {
        if (n == 1)
            return 1;
        int count = 0;

        double limit = Math.sqrt(n);

        for(int i = 1; i < limit; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        // is a square number
        if (Math.sqrt(n) == Math.floor(Math.sqrt(n)))
            return (2 * count) + 1;

        return 2 * count;
    }
}
