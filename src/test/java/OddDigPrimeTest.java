
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class OddDigPrimeTest {

    private static void testing(String i, String results) {
        assertEquals(results, i);
    }

    public static void tests(long[] list1, long[][] results) {
        for (int i = 0; i < list1.length; i++) {
            testing(Arrays.toString(OddDigPrime.onlyOddDigPrimes(list1[i])), Arrays.toString(results[i]));
        }
    }

    @Test
    public void test1() {
        System.out.println("Basic Tests");
        long[] l = new long[]{20, 40, 55, 60, 100};
        long[][] r = new long[][]{{7, 19, 31}, {9, 37, 53}, {10, 53, 59}, {11, 59, 71}, {15, 97, 113}};
        tests(l, r);
    }
}
