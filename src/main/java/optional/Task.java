package optional;

import java.util.UUID;
import streams.TaskType;

public class Task {
  private final String id;
  private final String title;
  private final TaskType type;
  private User assignedTo;

  public Task(String id, String title, TaskType type) {
    this.id = id;
    this.title = title;
    this.type = type;
  }

  public Task(String title, TaskType type) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public TaskType getType() {
    return type;
  }

  public User getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(User assignedTo) {
    this.assignedTo = assignedTo;
  }

}
