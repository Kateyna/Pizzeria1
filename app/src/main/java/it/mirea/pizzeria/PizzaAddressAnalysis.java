package it.mirea.pizzeria;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAddressAnalysis  {
    private  DataPizzaAPI api;
    private MutableLiveData<pizzas> pizzasMutableLiveData;




    public PizzaAddressAnalysis() {

        pizzasMutableLiveData = new MutableLiveData<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pizza-and-desserts.p.rapidapi.com/pizzas")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(DataPizzaAPI.class);

    }

    public void getIssues(String name, String price) {

        final MutableLiveData<pizzas> liveData = new MutableLiveData<>();

        Call<pizzas> call = api.getIssues(name,price);

        call.enqueue(new Callback<pizzas>() {
            @Override
            public void onResponse(Call<pizzas> name, Response<pizzas> response) {
                if (response.body() == null) {
                    pizzasMutableLiveData.postValue(response.body());
                    Log.v("Tag","the response" + response.body().toString());
                }

               }

            @Override
            public void onFailure(Call<pizzas> call, Throwable t) {
                pizzasMutableLiveData.postValue(null);

            }


        });
    }
    public LiveData<pizzas> getVolumesResponseLiveData() {
        return pizzasMutableLiveData;
    }

}
