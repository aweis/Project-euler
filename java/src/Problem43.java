import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.math.LongMath;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by adam on 1/10/16.
 */
public class Problem43 implements Euler {
    @Override
    public String answer() throws Exception {
        ArrayList<String> possibleNumbers = uniqueThreeDigitMultiplesOfN(17);
        int [] primes = {13,11,7,5,3,2};
        for(int prime : primes) {
            possibleNumbers = nextPossibleDigit(prime, possibleNumbers);
        }
        ArrayList<Long> numbers = Lists.newArrayList();
        for(String s : possibleNumbers) {
            numbers.add(Long.valueOf(prependMissingDigit(s)));
        }
        return Long.toString(numbers.stream().reduce(0l,(a,b) -> LongMath.checkedAdd(a,b)));
    }

    private String prependMissingDigit(String s) {
        Preconditions.checkArgument(s.length() == 9);
        Set<Character> set = Sets.newHashSet('0','1','2','3','4','5','6','7','8','9');
        for(char c :s.toCharArray()) {
            set.remove(c);
        }
        return set.toArray()[0] + s;
    }

    private ArrayList<String> nextPossibleDigit(int divisible, ArrayList<String> lastDigits) {
        ArrayList<String> al = Lists.newArrayList();
        for(String possible : lastDigits) {
            String firstTwo = possible.substring(0,2);
            for(int i = 0; i < 10; i++) {
                if((Integer.valueOf(i+firstTwo) % divisible == 0) && uniqueDigits(i+possible)) {
                    al.add(i+possible);
                }
            }
        }
        return al;
    }

    private ArrayList<String> uniqueThreeDigitMultiplesOfN(int n) {
        ArrayList<String> al = Lists.newArrayList();
        for(String s : threeDigitMultiplesOfN(n)) {
            if(uniqueDigits(s)) al.add(s);
        }
        return al;
    }

    private boolean uniqueDigits(String s) {
        boolean[] arr = new boolean[10];
        for(char c : s.toCharArray()) {
            int index = c-'0';
            if(arr[index]) return false;
            arr[index] = true;
        }
        return true;
    }

    private ArrayList<String> threeDigitMultiplesOfN(int n) {
        int counter = 1;
        ArrayList<String> al = Lists.newArrayList();
        while(n*counter < 1000) {
            if(n*counter > 100) {
                al.add(Integer.toString(n*counter));
            }
            counter++;
        }
        return al;
    }
}
