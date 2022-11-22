package it.mirea.pizzeria;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    @GET("repositories")
    Call<RecyclerList> getDataFromGitHubApi(@Query("q") String query);
}




