package streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import static java.util.function.Function.*;
import java.util.function.*;

public class StreamExamples {

  public static void main(String[] args) {
    Task task1 = new Task("Read Version Control with Git book", TaskType.READING,
        LocalDate.of(2015, Month.JULY, 10)).addTag("git").addTag("reading").addTag("books");

    Task task2 =
        new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2))
            .addTag("java8").addTag("reading").addTag("books");

    Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING,
        LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

    Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING,
        LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

    Task task5 = new Task("Read Domain Driven Design book", TaskType.READING,
        LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");
    
    Task task6 = new Task("Read Domain Driven Design book", TaskType.READING,
        LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

    List<Task> tasks = Arrays.asList(task1, task2, task3, task4, task5, task6);
    printList(tasks);
    /*
     * List<String> readingTasks = findAllReadingTaskTitlesSortedByCreationDate(tasks);
     * printList(readingTasks);
     * 
     * List<Task> distinctTasks = findAllDistinctTasks(tasks);
     * 
     * printList(distinctTasks);
     * 
     * List<String> top2ReadingTasks = findTop2ReadingTasksSortedByCreationDate(tasks);
     * printList(top2ReadingTasks);
     * 
     * System.out.println(countAllReadingTasks(tasks));
     * 
     * List<String> uniqueTags = findAllUniqueTags(tasks); printList(uniqueTags);
     * 
     * System.out.println("All Tasks have 'books' tag ? : " + isAllReadingTasksHaveTagBooks(tasks));
     * 
     * String allTaskTitles = joinAllTaskTitles(tasks); System.out.println(allTaskTitles);
     */
    Set<String> uniqueTaskTitles = getUniqueTitles(tasks);
    System.out.println(uniqueTaskTitles);
    
    Map<String,Task> taskMap = taskMap(tasks);
    System.out.println(taskMap);

  }
  
  // Example 1: Find all the reading task titles sorted by their creation date
  private static List<String> findAllReadingTaskTitlesSortedByCreationDate(List<Task> tasks) {
    return tasks.stream().
        filter(task -> task.getType() == TaskType.READING).
        sorted(Comparator.comparing(Task::getCreatedOn).reversed()).
        map(Task::getTitle).
        collect(Collectors.toList());
  }
  
  // Example 2: Find distinct tasks
  private static List<Task> findAllDistinctTasks(List<Task> tasks){
    return tasks.stream()
        .distinct()
        .collect(Collectors.toList());
  }
  
  //Example 3: Find top 2 reading tasks sorted by creation date
  private static List<String> findTop2ReadingTasksSortedByCreationDate(List<Task> tasks){
    return tasks.stream()
        .filter(task -> task.getType() == TaskType.READING)
        .sorted(Comparator.comparing(Task::getCreatedOn))
        .map(Task::getTitle)
        .limit(2)
        .collect(Collectors.toList());
        
  }
  
  //Example 4: Count all reading tasks
  private static long countAllReadingTasks(List<Task> tasks) {
    return tasks.stream()
        .filter(task -> task.getType() == TaskType.READING)
        .count();
  }
  
  //Example 5: Find all the unique tags from all tasks
  private static List<String> findAllUniqueTags(List<Task> tasks){
    return tasks.stream()
        .flatMap(task -> task.getTags().stream())
        .distinct()
        .collect(Collectors.toList());
  }
  
  //Example 6: Check if all reading tasks have tag books
  private static boolean isAllReadingTasksHaveTagBooks(List<Task> tasks) {
    return tasks.stream()
        .filter(task -> task.getType() == TaskType.READING)
        .allMatch(task -> task.getTags().contains("books"));
  }
  
  //Example 7: Creating a summary of all titles
  private static String joinAllTaskTitles(List<Task> tasks) {
    return tasks.stream()
        .map(Task::getTitle)
        .reduce((first,second) -> (first + "\n"+ second))
        .get();
  }
  
  // Collect all unique task titles
  private static Set<String> getUniqueTitles(List<Task> tasks){
    return tasks.stream()
        .map(Task::getTitle)
        .collect(Collectors.toSet());
  }
  
  // Collect data into a Map
  private static Map<String, Task> taskMap(List<Task> tasks){
    return tasks.stream()
        .collect(toMap(Task::getTitle, identity(), (t1,t2) -> t2));
  }
  
  //Print an task list
  private static <E> void printList(List<E> list) {
    list.stream().forEach(item -> System.out.println(item));
  }

}
