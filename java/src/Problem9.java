/**
 * Created by adam on 2/1/14.
 */
public class Problem9 implements Euler{
    final int sum = 1000;
    @Override
    public String answer() {
        for(int c = 3; c < sum; c++) {
            for(int b = 2; b < c; b++) {
                for(int a = 1; a < b; a++) {
                    if (((int)(Math.pow(a, 2) + Math.pow(b, 2)) == (int)Math.pow(c, 2)) && (a + b + c == sum)) {
                        return Integer.toString(a*b*c);
                    }
                }
            }
        }
        return "No answer";
    }
}
