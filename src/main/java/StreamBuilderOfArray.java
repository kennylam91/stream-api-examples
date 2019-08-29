import java.util.stream.Stream;

public class StreamBuilderOfArray {
    public static void main(String[] args) {
        Stream<Long> streamSecond = Stream.of(new Long[]{new Long(1), new Long(2), new Long(3), new Long(4)});
        streamSecond.forEach(p -> System.out.println(p));
    }
}
