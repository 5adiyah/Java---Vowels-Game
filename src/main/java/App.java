import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String firstInput = request.queryParams("phrase");
      request.session().attribute("phrase", firstInput);

      model.put("template", "templates/detector.vtl");

      Game newGame = new Game();
      String phrase = newGame.changeVowel(firstInput);
      model.put("phrase", phrase);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/guess", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/guess.vtl");
      request.session().attribute("phrase");

      String firstInput = request.session().attribute("phrase");
      String secondInput = request.queryParams("guess");
      // String original = request.session().attribute("phrase");

      model.put("secondInput", secondInput);
      model.put("phrase", request.session().attribute("phrase"));

      Game checkInput = new Game();
      Boolean results = checkInput.checkGuess(firstInput, secondInput);

      model.put("results", results);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
