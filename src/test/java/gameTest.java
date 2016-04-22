import org.junit.*;
import static org.junit.Assert.*;

public class gameTest {

  @Test
public void changeVowel_changeOneVowelAtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "c-t" ;
  assertEquals(expected, gameTest.changeVowel("cAt"));
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

  @Test
public void changeVowel_changeOneVowelUtoHyphen_String() {
  Game gameTest = new Game();
  String expected = "r-n" ;
  assertEquals(expected, gameTest.changeVowel("run"));
  }

  @Test
public void changeVowel_changeMultipleVowelstoHyphen_String() {
  Game gameTest = new Game();
  String expected = "-bst-nt---s" ;
  assertEquals(expected, gameTest.changeVowel("abstentious"));
  }

  @Test
public void changeVowel_handleInputOfSentences_String() {
  Game gameTest = new Game();
  String expected = "H- th-r- h-w -r- y--" ;
  assertEquals(expected, gameTest.changeVowel("Hi there how are you"));
  }

  @Test
public void changeVowel_handleUpperCaseVowels_String() {
  Game gameTest = new Game();
  String expected = "c-t" ;
  assertEquals(expected, gameTest.changeVowel("cAt"));
  }

  @Test
public void checkGuess_compareUserGuessToOriginalPhrase_Boolean() {
  Game gameTest = new Game();
  Boolean expected = true;
  assertEquals(expected, gameTest.checkGuess("cat", "cat"));
  }
}

//To Add: Capitalize first letter
