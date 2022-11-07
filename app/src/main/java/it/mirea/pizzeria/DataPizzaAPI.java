package it.mirea.pizzeria;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DataPizzaAPI {
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com",
            "X-RapidAPI-Key: 9edff72adcmsh6ab2ef3a0c711a7p1337a1jsn13c64de78821"
    })
    Call<List<DetailApiResponce>> getData();
}



