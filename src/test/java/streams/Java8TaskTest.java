package streams;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Java8TaskTest {

  @Test
  public void search() {
    assertEquals("abc", Java8Task.search(new ArrayList<>(Arrays.asList("abc", "bbb","", null))).get(0));
    assertEquals(true, Java8Task.search(new ArrayList<>(Arrays.asList("ab", "abcd"))).isEmpty());
    assertEquals("aaa", Java8Task.search(new ArrayList<>(Arrays.asList("aaa"))).get(0));
  }
  
  @Test
  public void testGetString() {
    assertEquals("o3,e44",Java8Task.getString(new ArrayList<>(Arrays.asList(3,44))));
  }
}
