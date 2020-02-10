package lambda;

public class FlyWithLambda {
  public static void main(String[] args) {
    Flyable flyWithLambda = (name) -> System.out.println("fly with lambda "+name);
    flyWithLambda.fly("Lam");
  }
}

