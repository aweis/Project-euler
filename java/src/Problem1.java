/**
 * Created by adam on 2/1/14.
 */
public class Problem1 implements Euler{
    static final int limit = 1000;
    static final int minimum = 3;
    /** The answer to problem 1
     *
     * @return the answer
     */
    public String answer() {
        int sum = 0;
        for (int i = minimum; i < limit; i++) {
           if (i % 3 == 0 || i % 5 == 0) {
              sum += i;
           }
        }
        return Integer.toString(sum);
    }
}