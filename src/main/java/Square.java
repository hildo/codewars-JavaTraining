
public class Square {

    public static boolean isSquare(int n) {
        int squareRoot = (int) Math.sqrt(n);
        return ((squareRoot * squareRoot) == n);
    }
}
