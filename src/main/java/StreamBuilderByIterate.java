import java.util.stream.Stream;

public class StreamBuilderByIterate {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(0, p -> p + 1).limit(10);
        stream.filter(p -> p % 2 == 0)
                .forEach(System.out::println);
    }
}
