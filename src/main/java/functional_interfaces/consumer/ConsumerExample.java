package functional_interfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import optional.User;

public class ConsumerExample {
  public static void main(String[] args) {
    Consumer<User> userSay = (user) -> {
      System.out.println(user.getUsername());
    };

    List<User> users = new ArrayList<>();
    users.add(new User("user1", 20));
    users.add(new User("user2", 21));
    users.add(new User("user3",30));
    users.stream().forEach(userSay::accept);
  };

}
