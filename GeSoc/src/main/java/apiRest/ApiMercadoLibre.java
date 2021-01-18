package apiRest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ApiMercadoLibre {
    private static ApiMercadoLibre instancia = null;
    Retrofit retrofit;

    private ApiMercadoLibre() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")//classified_locations/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiMercadoLibre instancia(){
        if(instancia== null){
            instancia = new ApiMercadoLibre();
        }
        return instancia;
    }

    public List<Countries> getCountries() throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<List<Countries>> requestCountries = mercadoLibreService.getCountries();
        Response<List<Countries>> responseCountries = requestCountries.execute();
        List<Countries> countries_List = responseCountries.body();
        return countries_List;
    }

    public Country getPais(String idPais) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Country> requestStates = mercadoLibreService.getCountry(idPais);
        Response<Country> responseStates = requestStates.execute();
        Country country = responseStates.body();
        return country;
    }


    public List<States> getStates(String idPais) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Country> requestStates = mercadoLibreService.getCountry(idPais);
        Response<Country> responseStates = requestStates.execute();
        Country country = responseStates.body();
        return country.states;
    }

    public List<Cities> getCities(String idProvincia) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<States> requestCities = mercadoLibreService.getStates(idProvincia);
        Response<States> responseCiudad = requestCities.execute();
       States state = responseCiudad.body();
        return state.cities;
    }

    public List<Currencies> getCurrencies() throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<List<Currencies>> requestCurrencies = mercadoLibreService.getCurrencies();
        Response<List<Currencies>> responseCurrencies = requestCurrencies.execute();
        List<Currencies> currencies_List = responseCurrencies.body();
        return currencies_List;
    }

    public Currencies getCurrencies(String idPais) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Currencies> requestCurrencies = mercadoLibreService.getCurrencies(idPais);
        Response<Currencies> responseCurrencies = requestCurrencies.execute();
        Currencies currencies = responseCurrencies.body();
        return currencies;
    }
}
