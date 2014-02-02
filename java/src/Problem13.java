import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Created by adam on 2/2/14.
 */
public class Problem13 implements Euler {
    BigInteger number;
    BufferedReader in;
    public Problem13() throws Exception {
        String file = "text/Problem13.txt";
        in = new BufferedReader(new FileReader(file));
        number = BigInteger.valueOf(0);
    }

    @Override
    public String answer() throws Exception {
        String currentLine;
        while((currentLine = in.readLine()) != null) {
            BigInteger temp = new BigInteger(currentLine);
            number = number.add(temp);
        }
        String numString = number.toString();
        return numString.substring(0,10);
    }
}
