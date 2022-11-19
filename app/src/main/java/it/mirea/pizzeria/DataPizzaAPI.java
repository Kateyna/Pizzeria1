package it.mirea.pizzeria;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DataPizzaAPI {
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-RapidAPI-Key': '1'"
    })

    Call<drinks> getIssues(@Query("strDrink") String strDrink);
                         //  @Query("price") String price);
}



