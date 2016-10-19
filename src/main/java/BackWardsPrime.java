import java.util.List;
import java.util.stream.Collectors;

public class BackWardsPrime {
    
    public static String backwardsPrime(long start, long end) {
        List<Long> reversePrimes = new java.util.ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                long j = reverseNumber(i);
                if ((i != j) && isPrime(j)) {
                    reversePrimes.add(i);
                }
            }
        }
        
        return reversePrimes.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
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
    
    private static long reverseNumber(long input) {
        long number = input;
        long reversedNumber = 0;
        long temp;
        
        while (number > 0) {
            temp = number % 10;
            reversedNumber = reversedNumber * 10 + temp;
            number = number / 10;
        }
        
        return reversedNumber;
    }
}
