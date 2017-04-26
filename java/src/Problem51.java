import java.util.*;

/**
 * Created by adam on 3/9/16.
 */
public class Problem51 implements Euler {
    @Override
    public String answer() throws Exception {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        int counter = 100;

        while(true) {
           if(EulerHelper.isPrime(counter)) {
               if(hasDuplicateDigits(counter)) {
                   Set<Integer> duplicateDigits = getDuplicatedDigits(counter);
                   for(int duplicateDigit: duplicateDigits) {
                       List<String> star_reps = gen_star_rep(String.valueOf(counter), (char)(duplicateDigit+'0'), 3);
                       for(String star_rep: star_reps) {
                           List<Integer> list = map.get(star_rep);
                           if(list == null) {
                               list = new ArrayList<Integer>();
                               list.add(counter);
                               map.put(star_rep, list);
                           } else {
                               list.add(counter);
                           }
                           if(list.size() == 8) {
                               return String.valueOf(list.get(0));
                           }
                       }
                   }
               }
           }
           counter++;
        }
    }

    private Set<Integer> getDuplicatedDigits(int number) {
        int place = 1;
        boolean[] array = new boolean[10];
        Set<Integer> ret = new HashSet<Integer>();

        int currentDigit;
        while(place < number) {
            currentDigit = (number / place) % 10;
            place = place * 10;
            if (array[currentDigit]) {
                ret.add(currentDigit);
            }
            array[currentDigit] = true;
        }

        return ret;
    }

    private boolean hasDuplicateDigits(int number) {
        int place = 1;
        boolean[] array = new boolean[10];

        int currentDigit;
        while(place < number) {
            currentDigit = (number / place) % 10;
            place = place * 10;
            if (array[currentDigit]) {
                return true;
            }
            array[currentDigit] = true;
        }

        return false;
    }

    private List<String> gen_star_rep(String s, char replace, int numTimes) {
       List<String> firstPass = gen_star_rep_h(s, replace, 0, numTimes, new ArrayList<String>());
        List<String> ret = new ArrayList<String>();
        for(String str: firstPass) {
            if(str.chars().filter(num -> num == '*').count() == numTimes) {
                ret.add(str);
            }
        }
        return ret;
    }

    private List<String> gen_star_rep_h(String s, char replace, int index, int numTimes, List<String> acc) {
        if (index == s.length()) {
            return acc;
        }

        char currChar = s.charAt(index);

        if (acc.isEmpty()) {
            acc.add("");
        }
        List<String> newAcc = new ArrayList<String>();

        for(String str: acc) {
            if (currChar == replace) {
                if (str.chars().filter(num -> num == '*').count() < numTimes) {
                    newAcc.add(str + "*");
                }
            }
            newAcc.add(str + currChar);
        }

        return gen_star_rep_h(s, replace, index+1, numTimes, newAcc);
    }

}
