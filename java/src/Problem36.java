import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by adam on 1/9/16.
 */
public class Problem36 implements Euler {
    @Override
    public String answer() throws Exception {
        List<Integer> store = Lists.newArrayList();
        for(int i = 0; i < 1000000; i++) {
            if(isPalindromic(i)) {
                store.add(i);
            }
        }

        return store.stream().reduce(0, (a,b) -> a+b).toString();
    }

    private boolean isPalindromic(int n) {
        return isPalindrome(Integer.toString(n)) && isPalindrome(Integer.toBinaryString(n));
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }
}
