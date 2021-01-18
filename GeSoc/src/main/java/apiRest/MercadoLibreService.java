package apiRest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MercadoLibreService {

    @GET("classified_locations/countries/")//trae los paises
    Call<List<Countries>> getCountries();

    @GET("classified_locations/countries/{idPais}")//trae las provincias y los datos del país.
    Call<Country> getCountry(@Path("idPais") String idPais);

    @GET("classified_locations/states/{idProvincia}")//trae las ciudades
    Call<States> getStates(@Path("idProvincia") String idProvincia);

    @GET("currencies/")
    Call<List<Currencies>> getCurrencies();//para obtener moneda de los países

    @GET("currencies/{idPais}")
    Call<Currencies> getCurrencies(@Path("idPais") String idPais);//para obtener moneda de los países

}
