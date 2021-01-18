package server;

import com.google.gson.Gson;

import org.json.JSONException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class Controlador {

    public Object areWeConnected(Request request, Response response) throws JSONException {
        Gson g = new Gson();
        String resp = g.toJson("Yes, we are!");

        response.type("application/json");

        return resp;

    }



    public ModelAndView index(Request request, Response response){
        return new ModelAndView(null, "index.hbs");
    }

    public ModelAndView g4(Request request, Response response){
        return new ModelAndView(null, "g4.hbs");
    }
    public ModelAndView home(Request request, Response response){
        return new ModelAndView(null, "home.hbs");
    }

    public ModelAndView login(Request request, Response response){
        System.out.println(request.queryParams("user"));
        System.out.println(request.queryParams("password"));
        return new ModelAndView(null, "home.hbs");
    }

}
