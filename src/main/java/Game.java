import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Game {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String userInput = request.queryParams("phrase");
      Game changeVowel = new Game();
      String phrase = Game.changeVowel(userInput);
      model.put("phrase", phrase);

      model.put("template", "templates/detector.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/guess", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String guessPhrase = request.queryParams("guess");
      String originalPhrase = request.queryParams("phrase");
      Game changeVowel = new Game();
      Boolean guess = Game.checkGuess(originalPhrase, guessPhrase);
      model.put("guess", guess);

      model.put("template", "templates/guess.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }

  public static String changeVowel(String input) {
    String[] splittedInput = input.split("");
    String newInput = "";

    for(Integer i = 0; i < splittedInput.length; i++){
      if ( splittedInput[i].equals("a") ||
           splittedInput[i].equals("A") ||
           splittedInput[i].equals("e") ||
           splittedInput[i].equals("E") ||
           splittedInput[i].equals("i") ||
           splittedInput[i].equals("I") ||
           splittedInput[i].equals("o") ||
           splittedInput[i].equals("O") ||
           splittedInput[i].equals("u") ||
           splittedInput[i].equals("U") ){
        splittedInput[i] = "-";
      }
      newInput = newInput + splittedInput[i];
    }

    input = newInput;
    return input;
  }

  public static Boolean checkGuess(String original, String guess) {
    Game changeVowel = new Game();
    String oldPhrase = Game.changeVowel(original);
    String newPhrase = Game.changeVowel(guess);

    if(oldPhrase.equals(newPhrase)){
      return true;
    } else {
      return false;
    }

}

}
