package functional_interfaces.function;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import optional.User;

public class FunctionExample {

  public static void main(String[] args) {
    Function<User, Integer> getBirthYear = (user) -> {
      int year = Year.now().getValue();
      return year - user.getAge();
    };
    List<User> users = new ArrayList<>();
    users.add(new User("user1", 20));
    users.add(new User("user2", 21));
    users.add(new User("user3",30));
    List<Integer> birthYears = users.stream().map(getBirthYear::apply).collect(Collectors.toList());
    System.out.println(birthYears);
  };
}

