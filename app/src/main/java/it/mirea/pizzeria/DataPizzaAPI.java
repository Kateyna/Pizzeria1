package it.mirea.pizzeria;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DataPizzaAPI {
    @POST("api/4_1/rs/suggest/address")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<PizzaAddressAnalysis.AddressResponse> listAddress(@Body PizzaAddressAnalysis.AddressRequest request, @Header("Autorization") String token);
}
