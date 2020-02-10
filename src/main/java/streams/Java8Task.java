package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.StringUtils;
public class Java8Task {

  //Find the average of a list of integers
  public static Double getAvg(List<Integer> list) {
    long total = list.stream()
        .reduce(0, (sum,element) -> sum+element);
    return (double)total/list.size();
  }
  
  public static Double average(List<Integer> list) {
    return list.stream()
        .mapToInt(i -> i)
        .average()
        .orElse(0D);
  }
  
  public List<String> upperCase(List<String> list) {
    return list.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }
  
  public static List<String> search(List<String> list){
    return list.stream()
            .filter(item -> StringUtils.startsWith(item, "a"))
            .filter(item -> StringUtils.length(item) == 3)
            .collect(Collectors.toList());
  }
  
  public static List<String> search2(List<String> list){
    return list.stream()
        .filter(s -> s.startsWith("a"))
        .filter(s -> s.length() == 3)
        .collect(Collectors.toList());
  }
  
  public static String getString(List<Integer> list) {
    return list.stream()
        .map(item -> ((item & 1) == 0) ? ("e" + item) : ("o" + item))
        .collect(Collectors.joining(","));
  }
  
  
}
