package it.mirea.pizzeria;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataPizzaAPI {
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-RapidAPI-Key': '9edff72adcmsh6ab2ef3a0c711a7p1337a1jsn13c64de78821'",
            "X-RapidAPI-Host': 'pizza-and-desserts.p.rapidapi.com'"
    })
    @GET("/pizzas")
    Call<pizzas> getIssues(@Query("n") String name,
                           @Query("price") String price);
}



