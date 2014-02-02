import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by adam on 2/1/14.
 */
public class Problem8 implements Euler {
    final String file = "text/Problem8.txt";
    final String number;
    BigInteger b;
    BufferedReader in;
    public Problem8() throws Exception {
        String currentLine;
        StringBuffer buf = new StringBuffer();
        in = new BufferedReader(new FileReader(file));
        while ((currentLine = in.readLine()) != null) {
            buf.append(currentLine);
        }
        number = buf.toString();
    }
    @Override
    public String answer() {
        int max_product = 0;
        for(int i = 0; i < number.length()-4; i++) {
            int temp = productOfFive(number.substring(i, i+5));
            if(temp > max_product) {
                max_product = temp;
            }
        }
        return Integer.toString(max_product);
    }

    private int productOfFive(String num) {
        int product = 1;
        for(int i = 0; i < num.length(); i++) {
            product *= (num.charAt(i)-'0');
        }
        return product;
    }
}
