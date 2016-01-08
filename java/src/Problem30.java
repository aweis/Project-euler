import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 1/7/16.
 */
public class Problem30 implements Euler{

    @Override
    public String answer() throws Exception {
        int total = -1; // Accounts for 1 being found by default
        int counter = 1;
        while(true) {
            if(number_can_be_written_sum_of_powers_of_digits(counter, 5)) {
                total += counter;
            }
            if (counter > 1000000) {
                break;
            }
            counter++;
        }
        return Integer.toString(total);
    }

    private boolean number_can_be_written_sum_of_powers_of_digits(int number, final int power) {

        Iterable digits = Splitter.fixedLength(1).split(Integer.toString(number));
        digits = Iterables.transform(digits, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return IntMath.checkedPow(Integer.valueOf(s), power);
            }
        });
        int sum = 0;
        for(Object x : digits) {
            sum += (Integer)x;
        }
        return sum == number;
    }
}
