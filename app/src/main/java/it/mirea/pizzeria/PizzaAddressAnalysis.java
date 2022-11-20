package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PizzaAddressAnalysis {
    private DataPizzaAPI api;
    private MutableLiveData<List<list>> pizzasMutableLiveData;


    public PizzaAddressAnalysis() {

        pizzasMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        api = new retrofit2.Retrofit.Builder()
                .baseUrl("https://globalapi.dodopizza.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataPizzaAPI.class);


        }

    public void newPizzas(String name) {
        api.newPizzas(name)
                .enqueue(new Callback<List<list>>() {
                    @Override
                    public void onResponse(Call<List<list>> call, Response<List<list>> response) {
                        if (response.body() != null) {
                            pizzasMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<list>> call, Throwable t) {
                        pizzasMutableLiveData.setValue(null);
                    }
                });
    }

        public LiveData<List<list>> getVolumesResponseLiveData () {
            return pizzasMutableLiveData;
        }

    }

