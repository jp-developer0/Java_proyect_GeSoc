package pruebasAPI;

import apiRest.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestAPI {

    public static void main(String[] args) throws IOException {

        ApiMercadoLibre apiMercadoLibre = ApiMercadoLibre.instancia();

        List<Countries> countries_list = apiMercadoLibre.getCountries();
        System.out.println("Paises disponibles : ");

        for(Countries aCountrie:countries_list){
            System.out.println(aCountrie.id + ") " + aCountrie.name);
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese idPais para obtener sus provincias y su tipo de moneda : ");
        String idPais = teclado.next();

        List<States> states = apiMercadoLibre.getStates(idPais);

        for (States st : states) {
            System.out.println(st.id + ") " + st.name);
        }

        Country moneda = apiMercadoLibre.getPais(idPais);
        Currencies currencies = apiMercadoLibre.getCurrencies(moneda.currency_id);
        System.out.println("Moneda del país : id = " + moneda.currency_id + " y el tipo es " + currencies.getDescription());


        System.out.println("Ingrese idProvincia para obtener sus ciudades : ");
        String provincia = teclado.next();

        List<Cities> cities = apiMercadoLibre.getCities(provincia);

        for (Cities ct : cities) {
            System.out.println(ct.id + ") " + ct.name);
        }


        System.out.println("Monedas disponibles en Mercado Libre : ");
        List<Currencies> currencies_list = apiMercadoLibre.getCurrencies();

        for(Currencies aCurrencies:currencies_list){
            System.out.println("El id es : "+ aCurrencies.id + ", el tipo de moneda es : " + aCurrencies.description);
        }
    }

}
