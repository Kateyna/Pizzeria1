package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.BuildConfig;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAddressAnalysis {
    private  DataPizzaAPI api;


    public PizzaAddressAnalysis() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(DataPizzaAPI.class);

        Call<List<DetailApiResponce>> call = api.getData();

        call.enqueue(new Callback<List<DetailApiResponce>>() {
            @Override
            public void onResponse(Call<List<DetailApiResponce>> call, Response<List<DetailApiResponce>> response) {
                List<DetailApiResponce> apis = response.body();


            }

            @Override
            public void onFailure(Call<List<DetailApiResponce>> call, Throwable t) {


            }
        });
    }



}
