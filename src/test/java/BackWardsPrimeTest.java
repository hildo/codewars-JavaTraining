
import static org.junit.Assert.*;
import org.junit.Test;

public class BackWardsPrimeTest {

    @Test
    public void backWardsPrime13() {
        assertEquals("13 17 31 37 71 73 79 97", BackWardsPrime.backwardsPrime(1, 100));
    }

    @Test
    public void backWardsPrime21() {
        assertEquals("9923 9931 9941 9967", BackWardsPrime.backwardsPrime(9900, 10000));
    }

    @Test
    public void backWardsPrime1() {
        assertEquals("7027 7043 7057", BackWardsPrime.backwardsPrime(7000, 7100));
    }
    
    @Test
    public void backWardsPrime2() {
        assertEquals("70001 70009 70061 70079 70121 70141 70163 70241", BackWardsPrime.backwardsPrime(70000, 70245));
    }

    @Test
    public void backWardsPrime3() {
        assertEquals("70489 70529 70573 70589", BackWardsPrime.backwardsPrime(70485, 70600));
    }

    @Test
    public void backWardsPrime4() {
        assertEquals("", BackWardsPrime.backwardsPrime(60000, 70000));
    }

    @Test
    public void backWardsPrime5() {
        assertEquals("109537 109579 109583 109609 109663", BackWardsPrime.backwardsPrime(109500, 109700));
    }

//    @Test
    public void backWardsPrime6() {
        assertEquals("109537 109579 109583 109609 109663", BackWardsPrime.backwardsPrime(1095000, 1095403));
    }

    @Test
    public void backWardsPrime7() {
        assertEquals("107 113 149 157 167 179 199 311 337 347 359 389", BackWardsPrime.backwardsPrime(100, 403));
    }

    @Test
    public void backWardsPrime8() {
        assertEquals("", BackWardsPrime.backwardsPrime(400, 503));
    }

    @Test
    public void backWardsPrime9() {
        assertEquals("", BackWardsPrime.backwardsPrime(7048500, 7048600));
    }
    
}
