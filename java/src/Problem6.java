import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 2/1/14.
 */
public class Problem6 {
    public String answer() {
        int min = 1;
        int max = 100;
        List<Integer> l = new LinkedList<Integer>();
        for(int i = min; i <= max; i++) {
            l.add(i);
        }
        return Integer.toString(sumOfN(l) - sumOfSquares(l));
    }
    private int sumOfSquares(List<Integer> l) {
        int sum = 0;
        for(int i : l) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }
    private int sumOfN(List<Integer> l) {
        int sum = 0;
        for(int i : l) {
            sum += i;
        }
        return (int)Math.pow(sum, 2);
    }

}
