package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class OptionalExamples {

  public static void main(String[] args) {
    Optional<String> gender = Optional.of("MALE");
    String nullableGender = null;
    Optional<String> nullableGenderOptional = Optional.ofNullable(nullableGender);
    System.out.println("Optional of method: "+gender);
    System.out.println("Nullable optional: " + nullableGenderOptional);
    
    //orElseGet method + Supplier
    Supplier<String> nameSupplier = () -> "Noname";
    String name = nullableGenderOptional
        .orElseGet(nameSupplier);
    System.out.println(name);
    
    //ifPresent method + Consumer
    System.out.println("ifPresent method: ");
    Consumer<String> nameConsumer = (str) -> System.out.println(str);
    Optional.ofNullable("IfPresent name").ifPresent(nameConsumer);
    
    //filter method + Predicate
    System.out.println("filter method");
    Predicate<String> nameLongerThan3 = (str) -> str.length()>3;
    String newName = Optional.ofNullable("abc").filter(nameLongerThan3).orElseGet(nameSupplier);
    System.out.println(newName);
    
    //map method + Function
    System.out.println("map method:");
    
  }
}
