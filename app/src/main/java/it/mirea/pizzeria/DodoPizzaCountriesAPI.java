package it.mirea.pizzeria;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DodoPizzaCountriesAPI {

    @GET ("api/v1/countries/list")
    Call<CountriesPOJO> getDododata();

}



