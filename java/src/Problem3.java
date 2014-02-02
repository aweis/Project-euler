/**
 * Created by adam on 2/1/14.
 */
public class Problem3 implements Euler {
    static final long input = 600851475143L;
    /** The answer to problem 3
     *
     * @return the answer
     */
    public String answer() {
       long rest = input;
       long largestKnown = input;
       int primeFactor = 2;
       while(rest != 1) {
           while(rest % primeFactor == 0) {
                rest = rest / primeFactor;
                largestKnown = primeFactor;
           }
           primeFactor++;
       }
       return Long.toString(largestKnown);
    }
}