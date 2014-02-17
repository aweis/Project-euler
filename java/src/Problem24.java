import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by adam on 2/16/14.
 */
public class Problem24 implements Euler {
    @Override
    public String answer() throws Exception {
        int max = 1000000;
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int count = 1;
        while(true) {
            if(count == max) {
                return Arrays.toString(a);
            }
            count++;
            int k = findLargestK(a);
            if (k == -1) {
                System.out.println("Done");
                break;
            }
            int l = findLargestL(a, k);
            swap(a, k, l);
            reverseToEnd(a, k);
        }
        return "";
    }

    // Find the largest index k such that a[k] < a[k+1]
    // returns -1 if no index exists (last permutation)
    private int findLargestK(int[] a) {
        int largestK = -1;
        for(int k = 0; k < a.length-1; k++) {
            if(a[k] < a[k+1]) {
                largestK = k;
            }
        }
        return largestK;
    }

    // Find the largest index l such that a[k] < a[l]
    private int findLargestL(int[] a, int k) {
        int largestL = -1;
        for(int l = 0; l < a.length; l++) {
           if(a[k] < a[l]) {
                largestL = l;
           }
        }
        return largestL;
    }

    private void swap(int[] a, int k, int l) {
        int temp = a[k];
        a[k] = a[l];
        a[l] = temp;
    }

    private void reverseToEnd(int[] a, int k) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = k+1; i < a.length; i++) {
            s.push(a[i]);
        }
        for(int i = k+1; i < a.length; i++) {
            a[i] = s.pop();
        }
    }
}
