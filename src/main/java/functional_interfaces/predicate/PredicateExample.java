package functional_interfaces.predicate;

import java.util.function.Predicate;
import optional.User;

public class PredicateExample {
  public static void main(String[] args) {
    Predicate<User> checkAgeOver18 = user -> user.getAge() > 18;
    User user = new User("user",20);
    boolean checkAge = checkAgeOver18.test(user);
    System.out.println(checkAge);
  }

}
