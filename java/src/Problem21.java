import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adam on 2/16/14.
 */
public class Problem21 implements Euler {
    @Override
    public String answer() throws Exception {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 1; i < 10000; i++) {
            map.put(i, foldSum(properDivisors(i)));
        }
        int acc = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (map.containsKey(entry.getValue()) && !map.get(entry.getValue()).equals(entry.getValue())) {
                if (map.get(entry.getValue()).equals(entry.getKey())) {
                    acc+=entry.getValue();
                }
            }
        }
        return Integer.toString(acc);
    }

    private int foldSum(ArrayList<Integer> a) {
        int sum = 0;
        for(int x : a) {
            sum+=x;
        }
        return sum;
    }

    private ArrayList<Integer> properDivisors(int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 1; i <= n/2; i++) {
            if(n % i == 0) {
                a.add(i);
            }
        }
        return a;
    }
}
