import org.junit.*;
import static org.junit.Assert.*;

public class gameTest {

  @Test
public void changeVowel_changeOneVowelAtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "c-t" ;
  assertEquals(expected, gameTest.changeVowel("cat"));
  }

  @Test
public void changeVowel_changeOneVowelEtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "p-t" ;
  assertEquals(expected, gameTest.changeVowel("pet"));
  }

  @Test
public void changeVowel_changeOneVowelItoHyphen_String() {
  Game gameTest = new Game();
  String expected = "s-t" ;
  assertEquals(expected, gameTest.changeVowel("sit"));
  }

  @Test
public void changeVowel_changeOneVowelOtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "d-g" ;
  assertEquals(expected, gameTest.changeVowel("dog"));
  }
}
