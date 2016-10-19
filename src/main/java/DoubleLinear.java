import java.util.NavigableSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

class DoubleLinear {
    
    public static int dblLinear (int n) {
        Stream<Integer> dblLinearStream = Stream.generate(new DblLinearSupplier());
        return dblLinearStream.skip(n).findFirst().get();
    }
    
    private static class DblLinearSupplier implements Supplier<Integer> {

        private final NavigableSet<Integer> numbers = new java.util.TreeSet<>();
        
        DblLinearSupplier() {
            numbers.add(1);
        }
        
        @Override
        public Integer get() {
            Integer x  = numbers.pollFirst();
            numbers.add((2*x) + 1);
            numbers.add((3*x) + 1);
            return x;
        }
        
    }
}