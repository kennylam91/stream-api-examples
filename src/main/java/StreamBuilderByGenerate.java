import java.util.Date;
import java.util.stream.Stream;

public class StreamBuilderByGenerate {
    public static void main(String[] args) {
        Stream<Date> stream = Stream.generate(
                () -> {
                    return new Date();
                }
        ).limit(10);
        stream.forEach(System.out::println);
    }
}
