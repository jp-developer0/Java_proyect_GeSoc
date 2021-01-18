package apiRest;

import com.google.gson.JsonObject;
import operacionEgreso.VinculadorOperaciones;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;

import java.util.List;

public interface ComponenteExternoService {

    @GET("hola")
    Call<JsonObject> getHandShake();

    @GET("vincular/{id}")
    Call<VinculadorOperaciones>  postOperaciones(@Path("id") String id);

}
