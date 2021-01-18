package apiRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import operacionEgreso.VinculadorOperaciones;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ApiComponenteExterno {
    private static ApiComponenteExterno instancia = null;
    Retrofit retrofit;

    private ApiComponenteExterno() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://vinculador.herokuapp.com/")//classified_locations/  "http://localhost:9002/"
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static ApiComponenteExterno instancia(){
        if(instancia== null){
            instancia = new ApiComponenteExterno();
        }
        return instancia;
    }

    public JsonObject getHandShake() throws IOException {
        ComponenteExternoService componenteExternoService = this.retrofit.create(ComponenteExternoService.class);
        Call<JsonObject> requestHandShake = componenteExternoService.getHandShake();
        Response<JsonObject> responseHandShake = requestHandShake.execute();
        JsonObject response = responseHandShake.body();
        return response;
    }

    public Response<VinculadorOperaciones> enviarJson(String json) throws Exception{
        ComponenteExternoService componenteExternoService = this.retrofit.create(ComponenteExternoService.class);
        Call<VinculadorOperaciones> requestJson = componenteExternoService.postOperaciones(json);
        Response<VinculadorOperaciones> vinculadorOperacionesResponse = requestJson.execute();

        return vinculadorOperacionesResponse;
    }

}
