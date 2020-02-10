package lambda;

public class Fly1 {

  public static void main(String[] args) {
    Flyable fly1 = new Flyable() {
      public void fly(String name) {
        System.out.println("Fly 1 "+name);
      }
    };
    fly1.fly("Chip");
  }
}
