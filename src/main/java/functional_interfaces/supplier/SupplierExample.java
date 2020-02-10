package functional_interfaces.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import optional.User;

public class SupplierExample {
  public static void main(String[] args) {
    Supplier<User> friendSupply = () -> new User("friend");
    List<User> users = new ArrayList<>();
    users.add(new User("user1", 20));
    users.add(new User("user2", 21));
    users.add(new User("user3",30));
    User friend = friendSupply.get();
    System.out.println(friend);
  }

}
