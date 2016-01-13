import com.google.common.base.Preconditions;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by adam on 1/12/16.
 */
public class Problem44 implements Euler {
    class PentagonalNumberStore {
        TreeSet<Integer> set;
        public PentagonalNumberStore(){
            this.set = new TreeSet<Integer>();
            this.set.add(1);
        }
        public int getPentagonal(int n) {
            return n*(3*n-1)/2;
        }

        public boolean contains(int pentagonal) {
            computeUpTo(pentagonal);
            return set.contains(pentagonal);
        }

        private void computeUpTo(int n) {
            Preconditions.checkArgument(n>0);
            while(set.last() < n) {
                set.add(getPentagonal(set.size()+1));
            }
        }
    }
    @Override
    public String answer() throws Exception {
        PentagonalNumberStore store = new PentagonalNumberStore();
        for(int i = 1; i < 10000; i++) {
            for(int j = 1; j < i; j++) {
                int sum = store.getPentagonal(i) + store.getPentagonal(j);
                int difference = store.getPentagonal(i) - store.getPentagonal(j);
                if(store.contains(sum) && store.contains(difference)) {
                    return Integer.toString(difference);
                }
            }
        }
        return null;
    }
}
