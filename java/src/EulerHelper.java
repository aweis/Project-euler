/**
 * Created by adam on 1/7/16.
 */
public class EulerHelper {
    // Found here: http://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java
    public static Boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}
