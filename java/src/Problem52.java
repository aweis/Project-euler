import java.util.Arrays;

/**
 * Created by adam on 3/9/16.
 */
public class Problem52 implements Euler {
    @Override
    public String answer() throws Exception {
        for(int i = 1; i < 1000000; i++) {
            if(sameDigits(i)) {
                return String.valueOf(i);
            }
        }
        return null;
    }

    private boolean sameDigits(int n) {
        String s1 = sortedNumber(n);
        String s2 = sortedNumber(n*2);
        String s3 = sortedNumber(n*3);
        String s4 = sortedNumber(n*4);
        String s5 = sortedNumber(n*5);
        String s6 = sortedNumber(n*6);

        return s1.equals(s2) && s1.equals(s3) && s1.equals(s4) && s1.equals(s5)
                && s1.equals(s6);
    }

    private String sortedNumber(int n) {
        char[] s1 = String.valueOf(n).toCharArray();
        Arrays.sort(s1);

        return String.valueOf(s1);
    }
}
