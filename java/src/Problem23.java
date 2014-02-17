import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adam on 2/16/14.
 */
public class Problem23 implements Euler {
    @Override
    public String answer() throws Exception {
        ArrayList<Integer> abundantNums = new ArrayList<Integer>();
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 1; i <= 28123; i++) {
            ArrayList<Integer> divisors = properDivisors(i);
            int sum = foldSum(divisors);
            if (sum > i) {
                abundantNums.add(i);
            }
        }
        for(int i : abundantNums) {
            for(int j : abundantNums) {
                int sumOfAbundantNums = i + j;
                map.put(sumOfAbundantNums, true);
            }
        }
        int acc = 0;
        for(int i = 1; i <= 28123; i++) {
            if (!map.containsKey(i)) {
                acc+=i;
            }
        }
        return Integer.toString(acc);
    }
    private ArrayList<Integer> properDivisors(int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 1; i <= n/2; i++) {
            if(n%i == 0) {
                a.add(i);
            }
        }
        return a;
    }
    private int foldSum(ArrayList<Integer> a) {
        int sum = 0;
        for(int temp: a) {
            sum += temp;
        }
        return sum;
    }
}
