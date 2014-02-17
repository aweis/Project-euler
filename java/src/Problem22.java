import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by adam on 2/16/14.
 */
public class Problem22 implements Euler {
    @Override
    public String answer() throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("text/Problem22.txt"));
        String currentLine;
        StringBuffer buf = new StringBuffer();
        while((currentLine = b.readLine())!= null) {
            buf.append(currentLine);
        }
        String[] s = buf.toString().split(",");
        Arrays.sort(s);
        int acc = 0;
        for(int i = 0; i < s.length; i++) {
            acc+=(i+1)*nameValue(s[i]);
        }
        return Integer.toString(acc);
    }

    private int nameValue(String name) {
        int value = 0;
        for(char c : name.toCharArray()) {
            if(c != '"')
                value+=(c-'A'+1);
        }
        return value;
    }
}
