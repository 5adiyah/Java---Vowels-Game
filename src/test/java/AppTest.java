import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Vowels Game");
  }
  @Test
  public void changeVowel() {
    goTo("http://localhost:4567/");
    fill("#phrase").with("Hello");
    submit(".button");
    assertThat(pageSource()).contains("My Guess");
  }

  @Test
  public void checkGuess() {
    goTo("http://localhost:4567/detector");
    fill("#guess").with("Hello");
    submit(".button");
    assertThat(pageSource()).contains("Original Phrase was");
  }

}
