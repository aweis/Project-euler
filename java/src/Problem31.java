import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adam on 1/7/16.
 */
public class Problem31 implements Euler {
    @Override
    public String answer() throws Exception {
        Integer[] denominations = {200,100,50,20,10,5,2,1};
        return Integer.toString(count_change(200, denominations));
    }

    private int count_change(int amount, Integer[] coins) {
        Preconditions.checkArgument(amount > 0);
        Arrays.sort(coins, Collections.reverseOrder());

        return count_change_h(amount, coins);
    }

    private int count_change_h(int amount, Integer[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (coins.length <= 0 && amount > 0) {
            return 0;
        }

        int current_coin = coins[0];
        Integer[] coins_remaining = Arrays.copyOfRange(coins, 1, coins.length);

        return count_change_h(amount, coins_remaining) + count_change_h(amount - current_coin, coins);
    }
}
