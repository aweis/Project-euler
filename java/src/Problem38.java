import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by adam on 1/9/16.
 */
public class Problem38 implements Euler {
    @Override
    public String answer() throws Exception {
        long max = 0;
        for(int i = 1; i < 10000; i++) {
            long value = is_eventually_pandigital(i);
            if(value > 0) {
                if(value > max) {
                    max = value;
                }
            }
        }
        return Long.toString(max);
    }

    private long is_eventually_pandigital(int n) {
        Preconditions.checkArgument(n > 0);
        int counter = 1;
        int[] store = new int[10];
        StringBuffer returner = new StringBuffer("");
        while(true) {
            String current = Integer.toString(counter * n);
            returner.append(current);
            for(char c: current.toCharArray()) {
                int current_digit = c-'0';
                if(current_digit == 0) {
                    return -1;
                } else {
                    store[current_digit]++;
                    if(store[current_digit] > 1) {
                        return -1;
                    }
                }
            }
            counter++;
            if(returner.length() == 9) {
                return Long.valueOf(returner.toString());
            }
            if (returner.length() > 9) {
                return -1;
            }
        }
    }
}
