package it.mirea.pizzeria;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataPizzaAPI {
    @GET("/repos/{owner}/{repo}/issues")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com",
            "X-RapidAPI-Key: 9edff72adcmsh6ab2ef3a0c711a7p1337a1jsn13c64de78821"
    })
    Call<DetailApiResponce> getIssues(@Path("owner") String owner,
                                @Path("repo") String repo);
}



