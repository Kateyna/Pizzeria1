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
    private MutableLiveData<drinks> pizzasMutableLiveData;




    public PizzaAddressAnalysis() {

        pizzasMutableLiveData = new MutableLiveData<>();


        api  = new retrofit2.Retrofit.Builder()
                .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataPizzaAPI.class);



    }

    public void getIssues(String strDrinkThumb) {
        api.getIssues(strDrinkThumb).enqueue(new Callback<drinks>() {
            @Override
            public void onResponse(Call<drinks> call, Response<drinks> response) {
                if (response.body() == null) {
                    pizzasMutableLiveData.setValue(response.body());
                    Log.v("Tag","the response" + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<drinks> call, Throwable t) {
                pizzasMutableLiveData.setValue(null);
            }
        });

    }
    public LiveData<drinks> getVolumesResponseLiveData() {
        return pizzasMutableLiveData;
    }

}
