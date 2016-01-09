import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by adam on 1/8/16.
 */
public class Problem33 implements Euler {
    @Override
    public String answer() throws Exception {
        List<Double> store = Lists.newArrayList();
        for(int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                if(curious_fraction(i, j)) {
                    store.add((double)i / j);
                }
            }
        }
        Double d = store.stream().reduce(1.0, (a,b) -> a*b);

        return Double.toString(d);
    }

    private boolean curious_fraction(int numerator, int denominator) {
        Preconditions.checkArgument(numerator >= 10 && numerator < 100);
        Preconditions.checkArgument(denominator >= 10 && denominator < 100);
        int first_numerator_digit = numerator / 10;
        int second_numerator_digit = numerator % 10;
        int first_denominator_digit = denominator / 10;
        int second_denominator_digit = denominator % 10;

        double regular_result = (double)numerator / (double)denominator;

        if(numerator >= denominator) {
            return false;
        }

        if (second_numerator_digit == 0 && second_denominator_digit == 0) {
            return false; // trivial case covered here
        }

        if (first_numerator_digit == first_denominator_digit) {
            return (((double)second_numerator_digit /(double)second_denominator_digit) == regular_result);
        }

        if (first_numerator_digit == second_denominator_digit) {
            return (((double)second_numerator_digit /(double)first_denominator_digit) == regular_result);
        }

        if (second_numerator_digit == first_denominator_digit) {
            return (((double)first_numerator_digit /(double)second_denominator_digit) == regular_result);
        }

        if (second_numerator_digit == second_denominator_digit) {
            return (((double)first_numerator_digit /(double)first_denominator_digit) == regular_result);
        }

        return false;
    }
}
