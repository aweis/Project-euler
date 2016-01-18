import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by adam on 1/17/16.
 */
public class Problem49 implements Euler {
    @Override
    public String answer() throws Exception {
        return fourDigitPrimes();
    }

    private String fourDigitPrimes() {
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int i = 1000; i < 10000; i++) {
           if(EulerHelper.isPrime(i)) {
               char[] numArray = Integer.toString(i).toCharArray();
               Arrays.sort(numArray);
               String num = String.valueOf(numArray);
               if(map.containsKey(num)) {
                   map.get(num).add(i);
               } else {
                   map.put(num, Sets.newHashSet(i));
               }
           }
        }
        for(String s : map.keySet()) {
            if(s.equals("1478")) continue; // Ignore the sample solution
            Set<Integer> v = map.get(s);
            if(v.size() >= 3) {g
                Map<Integer,Integer> differences = allDifferences(Lists.newArrayList(v));
                for(int key : differences.keySet()) {
                    if(differences.get(key)>=2) {
                        Set<Integer> solution = contains3digitsSeperatedByKEach(v, key);
                        if(!solution.isEmpty()) {
                            TreeSet<Integer> sortedSet = new TreeSet<Integer>();
                            sortedSet.addAll(solution); // G
                            StringBuffer answer = new StringBuffer();
                            for(int elem : sortedSet) {
                                answer.append(elem);
                            }
                            return answer.toString();
                        }
                    }
                }
            }
        }
        return null;
    }

    /* Returns empty set if no digit found, returns 3 elements in set if they are found */
    private Set<Integer> contains3digitsSeperatedByKEach(Set<Integer> set, int k) {
        for(int elem: set) {
            if(set.contains(elem - k) && set.contains(elem+k)) {
                return Sets.newHashSet(elem-k, elem, elem+k);
            }
        }
        return Sets.newHashSet();
    }

    /* n^2 to find all possible differences given Arraylist of numbers */
    private Map<Integer, Integer> allDifferences(ArrayList<Integer> numbers) {
        Map<Integer,Integer> map = Maps.newHashMap();
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = 0; j < numbers.size(); j++) {
                if(i==j) continue;
                if(numbers.get(i) < numbers.get(j)) continue;
                int difference = numbers.get(i) - numbers.get(j);
                if(map.containsKey(difference)) {
                    map.put(difference, map.get(difference)+1);
                } else {
                    map.put(difference, 1);
                }
            }
        }
        return map;
    }
}
