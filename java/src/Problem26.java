import java.util.*;

/**
 * Created by adam on 2/17/14.
 */
public class Problem26 implements Euler {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    @Override
    public String answer() throws Exception {
        int max = -1;
        int d = -1;
        for(int i = 3; i < 1000; i++) {
            hash.clear();
            //System.out.println("1/" + i);
            int current = divide(1, i);
            if (max < current) {
                max = current;
                d = i;
            }
            //System.out.println("The chain length for " + 1 + "/" + i + " is " + current);
        }
        //System.out.println("The max 1/d is 1/" + d + " with a length of " + max);
        return Integer.toString(d);
    }

    int howManyZeros(int divisor, int dividend) {
        int count = 0;
        while(true) {
            if (divisor > dividend) {
                return count;
            } else {
                divisor*=10;
                count++;
            }
        }
    }

    int findLargest(int dividend, int max) {
        int acc = dividend;
        while(true) {
            if (acc + dividend > max) {
                return acc;
            } else {
                acc = dividend + acc;
            }
        }
    }

    int howManyTimesDoesXgoIntoY(int x, int y) {
        return findLargest(x, y)/x;
    }

    int addZeros(int val, int numZeros) {
        return val * (int)(Math.pow(10, numZeros));
    }

    int divide(int divisor, int dividend) {
        return divide_h(divisor, dividend, 0, 0);
    }

    int divide_h(int divisor, int dividend, int count, int index) {
        //System.out.println("index: " + index + " Can " + divisor + " go into " + dividend + "?");
        if(canXgoIntoY(divisor, dividend)) {
            return -1;
        }
        else if(divisor == 0) {
            return -1;
        } else {
            int numZeros = howManyZeros(divisor, dividend);
         //   System.out.println("\tnumZeros= " + numZeros);
            int newNumber = addZeros(divisor, numZeros);
          //  System.out.println("\tnewNumber= "+newNumber);
            int howManyTimes = howManyTimesDoesXgoIntoY(dividend, newNumber);
            int nextNumber = newNumber-(howManyTimes*dividend);
           // System.out.println("\tnextNumber= "+nextNumber);
            //System.out.println("The cache: " + hash);
            if(hash.containsKey(nextNumber)) {
             //  System.out.println("Seen this before " + count + " at index " + hash.get(nextNumber));
               return count - hash.get(nextNumber);
            } else {
                hash.put(nextNumber, index);
                return divide_h(nextNumber, dividend, count + numZeros, index+1);
            }
        }
    }

    boolean canXgoIntoY(int x, int y) {
        return (x > y);
    }
}
