
public class DescendingOrder {

    public static int sortDesc(final int num) {
        // digits contains the digits in original order
        int[] digits = String.valueOf(num).chars().map(c -> Character.digit(c, 10)).toArray();
        // sortedDigits have the Integer objects (not raw int) in descending order
        // I wanted to do this in one line, but IntStream doesn't seem to allow mapping from
        // int to Integer
        Integer[] sortedDigits = new Integer[digits.length];
        for (int idx = 0; idx < digits.length; idx++) {
            sortedDigits[idx] = Integer.valueOf(digits[idx]);
        }
        java.util.Arrays.sort(sortedDigits, java.util.Collections.reverseOrder());
        
        // Loop through and build the new int
        int returnValue = 0;
        int placesIdx = sortedDigits.length - 1;        
        for (int idx = 0; idx < sortedDigits.length; idx++) {
            returnValue = returnValue + (sortedDigits[idx] * (int) Math.pow(10, placesIdx--));
        }
        return returnValue;
    }
}
