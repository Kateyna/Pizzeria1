package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroRepository {

    private RetroServiceInterface retroServiceInterface;

    public RetroRepository(RetroServiceInterface retroServiceInterface) {
        this.retroServiceInterface = retroServiceInterface;
    }

    public void makeAPICall(String query, MutableLiveData<List<RecyclerData>> liveData) {
        Call<RecyclerList> call  = retroServiceInterface.getDataFromGitHubApi(query);
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()) {
                    liveData.postValue(response.body().getItems());
                } else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveData.postValue(null);
            }
        });


    }
}
