import org.junit.*;
import static org.junit.Assert.*;

public class gameTest {

  @Test
public void changeVowel_changeOneVowelAtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "c-t" ;
  assertEquals(expected, gameTest.changeVowel("cat"));
  }
}
