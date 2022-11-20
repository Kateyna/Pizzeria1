package it.mirea.pizzeria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DataPizzaAPI {
    @Headers({
            "Accept: */*",
            "Host: <calculated when request is sent>",
            "User-Agent: PostmanRuntime/7.29.2",
            "Accept-Encoding: gzip, deflate, br",
            "Connection: keep-alive"
      //      "Content-Type: application/json",
       //     "Accept: application/json",
       //     "X-api-key': '1'"
    })

    @GET ("api/v1/countries/list")
    Call<List<list>> newPizzas(@Query("countries") String countries);
                         //  @Query("price") String price);
}



