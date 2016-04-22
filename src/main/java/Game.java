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
      } else if(splittedInput[i].equals(" ")){
        splittedInput[i] = "               ";
      }
      newInput = newInput + splittedInput[i];
    }

    input = newInput;
    return input;
  }

}
