package functional_interfaces;

public class SayableExamples {
  public static void main(String[] args) {
    Sayable obj = (mes) -> {
      System.out.println(mes);
    };
    obj.say("sayable is me");
  }
}
