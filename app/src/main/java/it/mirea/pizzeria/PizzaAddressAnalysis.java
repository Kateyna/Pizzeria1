package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAddressAnalysis {
    private DataPizzaAPI api;
    private MutableLiveData<List<countries>> pizzasMutableLiveData;



    public PizzaAddressAnalysis() {

        pizzasMutableLiveData = new MutableLiveData<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://globalapi.dodopizza.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataPizzaAPI api = retrofit.create(DataPizzaAPI.class);

        Call<List<countries>> call = api.newPizzas();


        call.enqueue(new Callback<List<countries>>() {
            @Override
            public void onResponse(Call<List<countries>> call, Response<List<countries>> response) {
                pizzasMutableLiveData.setValue(response.body());;
            }

            @Override
            public void onFailure(Call<List<countries>> call, Throwable t) {
                pizzasMutableLiveData.setValue(null);

            }
        });

    }

        public LiveData<List<countries>> getVolumesResponseLiveData () {
            return pizzasMutableLiveData;
        }

    }


