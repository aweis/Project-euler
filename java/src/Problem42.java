import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.StreamSupport;

/**
 * Created by adam on 1/10/16.
 */
public class Problem42 implements Euler{
    @Override
    public String answer() throws Exception {
        Map<String, Integer> map = readFileAndBuildMap();

        int maxValue = 0;
        for(String s : map.keySet()) {
            if(map.get(s) > maxValue) {
                maxValue = map.get(s);
            }
        }

        Set triangleNumbers = generateTriangleNumbersUpTo(maxValue);
        int triangleWords = 0;
        for(String s : map.keySet()) {
            if(triangleNumbers.contains(map.get(s))) {
                triangleWords++;
            }
        }
        return Integer.toString(triangleWords);
    }

    private Set<Integer> generateTriangleNumbersUpTo(int n) {
        Preconditions.checkArgument(n>0);
        Set<Integer> set = new HashSet();
        int counter = 1;
        while(true) {
            int triangleNumber = triangleNumber(counter);
            set.add(triangleNumber);
            if(triangleNumber > n) {
                return set;
            }
            counter++;
        }
    }

    private Map<String,Integer> readFileAndBuildMap() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader buf = new BufferedReader(new FileReader("text/Problem42.txt"));
        String current_line;
        while((current_line = buf.readLine()) != null) {
            String[] words = StreamSupport.stream(Splitter.on(",").split(current_line).spliterator(), false)
                          .map(word -> word.substring(1,word.length()-1)).toArray(size -> new String[size]);
            for(String word : words) {
                int wordValue = 0;
                for(char c : word.toCharArray()) {
                    wordValue += (c-'A'+1);
                }
                map.put(word, wordValue);
            }
        }
        return map;
    }

    private int triangleNumber(int n) {
        return (n * (n+1))/2;
    }
}
