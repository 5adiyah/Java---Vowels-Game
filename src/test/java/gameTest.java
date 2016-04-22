import org.junit.*;
import static org.junit.Assert.*;

public class name {

  @Test
public void changeVowel_acceptAndReturnString_expectedResult() {
  MainClassName testMainClassName = new MainClassName();
  String expected = "This" ;
  assertEquals(expected, testMainClassName.methodName("This"));
  }
}
