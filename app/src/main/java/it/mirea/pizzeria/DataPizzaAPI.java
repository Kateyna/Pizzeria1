package it.mirea.pizzeria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataPizzaAPI {

    @GET ("api/v1/countries/list")
    Call<List<countries>> newPizzas();
                         //  @Query("price") String price);
}



