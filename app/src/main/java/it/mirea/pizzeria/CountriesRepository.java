package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesRepository {
    private DodoPizzaCountriesAPI api;
    private MutableLiveData<List<countries>> DodoPizzaApiMutableData;



    public CountriesRepository() {
        DodoPizzaApiMutableData = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://globalapi.dodopizza.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DodoPizzaCountriesAPI api = retrofit.create(DodoPizzaCountriesAPI.class);

        Call<CountriesPOJO> call = api.getDododata();

        call.enqueue(new Callback<CountriesPOJO>() {
            @Override
            public void onResponse(Call<CountriesPOJO> call, Response<CountriesPOJO> response) {
                DodoPizzaApiMutableData.setValue(response.body().getCountries());;
            }

            @Override
            public void onFailure(Call<CountriesPOJO> call, Throwable t) {
                DodoPizzaApiMutableData.setValue(null);

            }
        });

    }

    public LiveData<List<countries>> DodoPizzaApiData () {
        return DodoPizzaApiMutableData;
    }

}