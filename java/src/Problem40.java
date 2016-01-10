/**
 * Created by adam on 1/10/16.
 */
public class Problem40 implements Euler {
    @Override
    public String answer() throws Exception {
        String numbers = get_lots_of_numbers();
        return Integer.toString((numbers.charAt(1-1)-'0')
                              * (numbers.charAt(10-1)-'0')
                              * (numbers.charAt(100-1)-'0')
                              * (numbers.charAt(1000-1)-'0')
                              * (numbers.charAt(10000-1)-'0')
                              * (numbers.charAt(100000-1)-'0')
                              * (numbers.charAt(1000000-1)-'0'));
    }

    private String get_lots_of_numbers() {
        StringBuffer buf = new StringBuffer("");
        int counter = 1;
        while(buf.length() < 1000000) {
            buf.append(Integer.toString(counter));
            counter+=1;
        }
        return buf.toString();
    }
}
