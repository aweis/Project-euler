/**
 * Created by adam on 2/1/14.
 */
public class Problem4 implements Euler {
    final static int max = 999;
    final static int min = 100;
    /** The answer to problem 4
     *
     * @return the answer
     */
    public String answer() {
        int i = max,j = max;
        int times = 0;
        int max_seen = 0;
        while(true) {
            int product = i*j;
            if (isPalindrome(product)) {
                if (product > max_seen)
                    max_seen = product;
            }
            i--;
            if (i < min) {
                j--;
                times++;
                i = max - times;
            }
            if (j < min) {
                return Integer.toString(max_seen);
            }
        }
    }

    /* Given an integer, return if it is a palindrome
        e.g. 9009 = true
     */
    private boolean isPalindrome(int input) {
        return isPalindrome(Integer.toString(input));
    }

    private boolean isPalindrome(String s) {
        switch(s.length()) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return s.charAt(0) == s.charAt(1);
            default: {
                return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(middle(s));
            }
        }
    }

    private String middle(String s) {
        return s.substring(1, s.length()-1);
    }
}
