import com.google.common.collect.*;
import com.google.common.math.IntMath;

import java.util.HashMap;
import java.util.List;

/**
 * Created by adam on 1/9/16.
 */
public class Problem39 implements Euler {
    /*


    a^2 + b^2 = c^2

    a + b + c = p
     */
    @Override
    public String answer() throws Exception {
        return Integer.toString(maximised_triangles());
    }

    private int maximised_triangles() {
        int a; int b;
        HashMap<Integer,Integer> store = new HashMap<Integer,Integer>();
        for(a = 1; a < 1000; a++) {
            for(b = 1; b < 1000; b++) {
                double c = Math.sqrt(IntMath.pow(a, 2) + IntMath.pow(b, 2));
                if(Math.floor(c) == c) {
                    int perimeter = a+b+(int)c;
                    if(perimeter < 1000) {
                        if(store.containsKey(perimeter)) {
                            store.put(perimeter, store.get(perimeter) + 1);
                        } else {
                            store.put(perimeter, 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        int max_perimeter = 0;
        for(int x : store.keySet()) {
            if(store.get(x) > max) {
                max = store.get(x);
                max_perimeter = x;
            }
        }
        return max_perimeter;
    }
}
