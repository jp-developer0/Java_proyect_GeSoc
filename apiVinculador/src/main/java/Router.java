import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkutils.BooleanHelper;
import sparkutils.HandlebarsTemplateEngineBuilder;
import sparkutils.BooleanHelper;

import javax.naming.ldap.Control;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        Controlador controlador = new Controlador();

        Spark.get("/vincular/:id", controlador::vincular);

        String json1 = "[{\"name\":\"Welcome to Tijuana TSM\"}]";
        JsonParser parser = new JsonParser();
        JsonArray gsonArr = parser.parse(json1).getAsJsonArray();
        JsonObject gsonObj = null;
        for (JsonElement obj : gsonArr) {
            gsonObj = obj.getAsJsonObject();
            
        }
        JsonObject finalGsonObj = gsonObj;
        Spark.get("/hola", (request, response) -> finalGsonObj);

    }

}