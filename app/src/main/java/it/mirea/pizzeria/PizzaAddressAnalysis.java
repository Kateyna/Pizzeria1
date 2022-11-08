package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAddressAnalysis  {
    private  DataPizzaAPI api;
    private MutableLiveData<DetailApiResponce> detailApiResponceMutableLiveData;




    public PizzaAddressAnalysis() {

        detailApiResponceMutableLiveData = new MutableLiveData<>();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/")
                .build();

        api = retrofit.create(DataPizzaAPI.class);

    }

    public LiveData<DetailApiResponce> getIssues(String owner, String repo) {

        final MutableLiveData<DetailApiResponce> liveData = new MutableLiveData<>();

        Call<DetailApiResponce> call = api.getIssues(owner,repo);

        call.enqueue(new Callback<DetailApiResponce>() {
            @Override
            public void onResponse(Call<DetailApiResponce> call, Response<DetailApiResponce> response) {
                detailApiResponceMutableLiveData.postValue(response.body());

                }

            @Override
            public void onFailure(Call<DetailApiResponce> call, Throwable t) {
                detailApiResponceMutableLiveData.postValue(null);
            }


        });
        return liveData;

    }
    public LiveData<DetailApiResponce> getVolumesResponseLiveData() {
        return detailApiResponceMutableLiveData;
    }

}
