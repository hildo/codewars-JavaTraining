
public class DoubleCola {

    public static String WhoIsNext(String[] names, int n) {
        int power = 0;
        double currentSubsetSize = names.length * Math.pow(2, power++);
        while (n > currentSubsetSize) {
            n -= currentSubsetSize;
            currentSubsetSize = names.length * Math.pow(2, power++);
        }
        // n <= currentSubsetSize.  Divide n by currentSubsetSize and find the percentage
        // the percentage will drive the name
        double perc = n / currentSubsetSize;
        double delimitingValue =  (double) 1 / (double) names.length;
        int nameIdx = 0;
        String returnValue = null;
        while (returnValue == null) {
            if (perc <= (delimitingValue * (nameIdx+1))) {
                returnValue = names[nameIdx];
            } else {
                nameIdx++;
            }
        }
        return returnValue;
    }
}
