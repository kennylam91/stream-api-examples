package streams;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Task {

  
  private String id;
  private final String title;
  private final TaskType type;
  private final LocalDate createdOn;
  private boolean done = false;
  private Set<String> tags = new HashSet<>();
  private LocalDate dueOn;
  
  public Task(String title, TaskType taskType, LocalDate createdOn) {
    this.title = title;
    this.type = taskType;
    this.createdOn = createdOn;
  }

  public Task addTag(String tag) {
    this.tags.add(tag);
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
    result = prime * result + (done ? 1231 : 1237);
    result = prime * result + ((dueOn == null) ? 0 : dueOn.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((tags == null) ? 0 : tags.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (createdOn == null) {
      if (other.createdOn != null)
        return false;
    } else if (!createdOn.equals(other.createdOn))
      return false;
    if (done != other.done)
      return false;
    if (dueOn == null) {
      if (other.dueOn != null)
        return false;
    } else if (!dueOn.equals(other.dueOn))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (tags == null) {
      if (other.tags != null)
        return false;
    } else if (!tags.equals(other.tags))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (type != other.type)
      return false;
    return true;
  }
  
  
  
}
