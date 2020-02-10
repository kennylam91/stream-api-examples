package optional;

public class User {
  private final String username;
  private String fullname;
  private int age;

  public User(String username) {
    this.username = username;
  }

  public User(String username,int age) {
    this.username = username;
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User [username=" + username + ", fullname=" + fullname + ", age=" + age + "]";
  }

}
