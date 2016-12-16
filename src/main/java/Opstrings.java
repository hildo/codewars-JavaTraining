import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Opstrings {
    
    public static String vertMirror (String strng) {
        return Stream.of(strng.split("\n"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining("\n"));
    }
    
    public static String horMirror (String strng) {
        List<String> origList = Stream.of(strng.split("\n"))
                .collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(origList);
        return origList.stream().collect(Collectors.joining("\n"));
    }
    
    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
    
}
