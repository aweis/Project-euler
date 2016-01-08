import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;

/**
 * Created by adam on 1/7/16.
 */
public class Problem28 implements Euler {
    public String answer() {
        return Integer.toString(sum_diagonals_nth_square(1001));
    }

    private int sum_diagonals_nth_square(int n) {
        Preconditions.checkArgument(n > 0, "n needs to be 1 or greater");
        Preconditions.checkArgument(n % 2 == 1, "n needs to be odd");
        if (n == 1) {
            return 1;
        }

        int top_right = IntMath.pow(n, 2);
        int top_left  = top_right - (n - 1);
        int bottom_left = top_left - (n - 1);
        int bottom_right = bottom_left - (n - 1);

        int sum = top_right + top_left + bottom_left + bottom_right;
        return IntMath.checkedAdd(sum, sum_diagonals_nth_square(n - 2));
    }
}
