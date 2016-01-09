import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by adam on 1/9/16.
 */
public class Problem37 implements Euler {

    @Override
    public String answer() throws Exception {
        List<Integer> store = Lists.newArrayList();
        int counter = 10;
        int found = 0;
        while(found < 11) {
            if (is_truncatable(counter)) {
                found++;
                store.add(counter);
            }
            counter++;
        }
        return store.stream().reduce(0, (a,b) -> a + b).toString();
    }

    private boolean is_truncatable(int n) {
        return is_truncatable_left(n) && is_truncatable_right(n);
    }

    private boolean is_truncatable_left(int n) {
        Preconditions.checkArgument(n > 0);
        if(n < 10) {
            return EulerHelper.isPrime(n);
        } else {
            return EulerHelper.isPrime(n) && is_truncatable_left(Integer.valueOf(Integer.toString(n).substring(1)));
        }
    }

    private boolean is_truncatable_right(int n) {
        Preconditions.checkArgument(n > 0);
        if(n < 10) {
            return EulerHelper.isPrime(n);
        } else {
            return EulerHelper.isPrime(n) && is_truncatable_right(n / 10);
        }
    }
}
