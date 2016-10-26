
import java.util.Arrays;
import java.util.List;


public class OddDigPrime {

    public static long[] onlyOddDigPrimes(long n) {
        List<Long> oddDigitPrimes = new java.util.ArrayList<>();
        for (long num = 3; num <= n; num++) {
            if (isOddDigPrime(num)) {
                oddDigitPrimes.add(num);
            }
        }
        long count = oddDigitPrimes.size();
        long largestBelow = oddDigitPrimes.get(oddDigitPrimes.size() - 1);
        long nextOddDigPrime;
        if (oddDigitPrimes.contains(n)) {
            nextOddDigPrime = n;
        } else {
            nextOddDigPrime = n+1;
            while (!isOddDigPrime(nextOddDigPrime)) {
                nextOddDigPrime++;
            }
        }
        return new long[] {count, largestBelow, nextOddDigPrime};
    }
    
    private static boolean isOddDigPrime(long number) {
        return isPrime(number) && hasOnlyOddDigits(number);
    }
    
    private static boolean isPrime(long number) {
        if (number % 2 == 0) return false;
        for (long i = 3; i * i <= number; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean hasOnlyOddDigits(long number) {
        int[] digits = String.valueOf(number).chars()
                .map(c -> Character.getNumericValue(c))
                .toArray();
        return Arrays.stream(digits).allMatch(i -> i % 2 != 0);
    }
}
