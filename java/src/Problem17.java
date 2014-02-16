import java.util.HashMap;

/**
 * Created by adam on 2/16/14.
 */
public class Problem17 implements Euler {
    HashMap<Integer, String> map;
    public Problem17() {
        map = new HashMap<Integer, String>();
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }
    @Override
    public String answer() throws Exception {
        int acc = 0;
        String word;
        for(int i = 1; i <= 1000; i++) {
            if (i < 10) {
               word = oneDigit(i);
            } else if (i < 100) {
               word = twoDigits(i);
            } else if (i < 1000) {
               word = threeDigits(i);
            } else {
               word = fourDigits(i);
            }
            acc += countLetters(word);
        }
        return Integer.toString(acc);
    }

    private int countLetters(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c != ' ' && c != '-') {
                count++;
            }
        }
        return count;
    }

    private String oneDigit(int i) {
        if(i >= 0 && i <= 9) {
            return map.get(i);
        } else {
            return "";
        }
    }
    private String twoDigits(int i) {
        if (i >= 10 && i <= 99) {
            if (i <= 20) {
                return map.get(i);
            } else {
                int first = i / 10;
                int last = i % 10;
                if (last == 0) {
                    return map.get(first*10);
                } else {
                    return map.get(first*10) + "-" + map.get(last);
                }
            }
        } else {
            return "";
        }
    }

    private String threeDigits(int i) {
        if (i >= 100 && i <= 999) {
            int first = i / 100;
            int lastTwo = i - (first * 100);
            if (i % 100 == 0) {
                return map.get(first) + " hundred";
            }
            if (lastTwo < 10) {
                return map.get(first) + " hundred and " + oneDigit(lastTwo);
            } else {
                return map.get(first) + " hundred and " + twoDigits(lastTwo);
            }
        } else {
            return "";
        }
    }

    private String fourDigits(int i) {
        return "one thousand";
    }
}
