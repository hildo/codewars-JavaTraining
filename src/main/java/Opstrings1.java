import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Opstrings1 {

    public static String rot(String strng) {
        return new StringBuilder(strng).reverse().toString();
    }
    public static String selfieAndRot(String strng) {
        String selfie = Stream.of(strng.split("\n"))
                .map(s -> s + getDots(s))
                .collect(Collectors.joining("\n"));
        return selfie + "\n" + rot(selfie);
    }
    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }

    private static String getDots(String s) {
        int stringLength = s.length();
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < stringLength; idx++) {
            sb.append(".");
        }
        return sb.toString();
    }
}
