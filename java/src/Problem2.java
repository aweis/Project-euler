/**
 * Created by adam on 2/1/14.
 */
public class Problem2 implements Euler {
    static final int limit = 4000000;
    /** The answer to problem 2
     *
     * @return the answer
     */
    public String answer() {
        int i = 1;
        int j = 2;
        int sum = j;
        while(true) {
            if(i < j) {
                i = i + j;
                if (i > limit)
                    break;
                if (i%2==0) {
                    sum+=i;
                }
            } else {
                j = i + j;
                if (j > limit)
                    break;
                if(j%2==0) {
                   sum+=j;
                }
            }
        }
        return Integer.toString(sum);
    }
}
