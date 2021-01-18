package pruebasComponenteExterno;

import apiRest.ApiComponenteExterno;
import com.google.gson.JsonObject;

import java.io.IOException;

public class TestHandShake {

    public static void main(String[] args) throws IOException {

        ApiComponenteExterno apiComponenteExterno = ApiComponenteExterno.instancia();

        JsonObject gsonObj = apiComponenteExterno.getHandShake();
        String name = gsonObj.get("name").getAsString();
        System.out.println(name);

        }

}
