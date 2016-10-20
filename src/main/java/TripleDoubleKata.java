public class TripleDoubleKata {

    private static int[] getDigits(long num) {
        return String.valueOf(num).chars().map(c -> Character.digit(c, 10)).toArray();
    }
    
    private static boolean hasRepeatingDigits(int[] digits, int count) {
        boolean returnValue = false;
        for (int idx = 0; idx <= digits.length - count; idx++) {
            final int toCheck = digits[idx];
            java.util.List<Integer> digitList = new java.util.ArrayList<>();
            for (int j = 0; j < count; j++) {
                digitList.add(digits[idx + j]);
            }
            if (digitList.stream().allMatch(n -> n == toCheck)) {
                returnValue = true;
                break;
            }
        }
        return returnValue;
    }
    
    public static int TripleDouble(long num1, long num2) {
        int[] digits = getDigits(num1);
        if (hasRepeatingDigits(digits, 3)) {
            digits = getDigits(num2);
            if (hasRepeatingDigits(digits, 2)) {
                return 1;
            }
        }
        return 0;
    }

}
