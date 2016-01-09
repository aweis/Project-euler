import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;

import java.util.List;

/**
 * Created by adam on 1/8/16.
 */
public class Problem34 implements Euler {

    @Override
    public String answer() throws Exception {
        List<Integer> store = Lists.newArrayList();
        for(int i = 0; i < 100000; i++) {
            if (curious_number(i)) {
                store.add(i);
            }
        }

        return store.stream().filter(x -> x != 1 && x != 2).reduce(0, (a, b) -> a + b).toString();
    }

    private boolean curious_number(int n) {
        int sum = Lists.newArrayList(Splitter.fixedLength(1).split(Integer.toString(n)))
                .stream()
                .mapToInt(x -> IntMath.factorial(Integer.valueOf(x)))
                .sum();
        return sum == n;
    }
}
