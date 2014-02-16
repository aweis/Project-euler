import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by adam on 2/16/14.
 */
public class Problem19 implements Euler {
    @Override
    public String answer() throws Exception {
        int count = 0;
        for(int year = 1901; year <= 2000; year++) {
            for(int month = 1; month <= 12; month++) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new SimpleDateFormat("dd/M/yyyy").parse("01/"+month+"/"+year));
                if(cal.get(cal.DAY_OF_WEEK) == 1) {
                    count++;
                }
            }
        }
        return Integer.toString(count);
    }
}
