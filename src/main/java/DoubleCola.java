
public class DoubleCola {

    public static String WhoIsNext(String[] names, int n) {
        int power = 0;
        double currentSubsetSize = 5 * Math.pow(2, power++);
        while (n > currentSubsetSize) {
            n -= currentSubsetSize;
            currentSubsetSize = 5 * Math.pow(2, power++);
        }
        // n <= currentSubsetSize.  Divide n by currentSubsetSize and find the percentage
        // the percentage will drive the name
        double perc = n / currentSubsetSize;
        if (perc <= .2) {
            return names[0];
        } else if (perc <= .4) {
            return names[1];
        } else if (perc <= .6) {
            return names[2];
        } else if (perc <= .8) {
            return names[3];
        } else {
            return names[4];
        }
    }

}
