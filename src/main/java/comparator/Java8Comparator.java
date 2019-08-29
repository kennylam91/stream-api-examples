package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Java8Comparator {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(3, "Lam", 28));
        persons.add(new Person(1, "Tuan", 22));
        persons.add(new Person(4, "An", 15));
        persons.add(new Person(2, "Dung", 20));
        persons.add(new Person(5, "Dat", 32));
        System.out.println("List of person before sorting Java < 1.8");
        persons.forEach(person -> System.out.println(person));

        //Java < 8
        System.out.println("List of person after sorting Java < 1.8");
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getId() - p2.getId();
            }
        });
        persons.forEach(person -> System.out.println(person));

        //Java 8
        persons.sort((p1, p2) -> p1.getId() - p2.getId());
        System.out.println("List of person after sorting Java 8");
        persons.forEach(person -> System.out.println(person));

        System.out.println("List of person after sorting by Age Java 8 using Stream");
        persons.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .forEach(System.out::println);

        System.out.println("List of person after sorting by Name using Java 8 Stream");
        persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
    }

}
