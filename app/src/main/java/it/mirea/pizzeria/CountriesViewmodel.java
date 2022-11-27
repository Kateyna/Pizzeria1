package it.mirea.pizzeria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class CountriesViewmodel extends AndroidViewModel {
    private LiveData<List<countries>> DodoPizzaApiLiveData;
    private CountriesRepository countriesRepository;
    // No argument constructor
    public CountriesViewmodel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        countriesRepository = new CountriesRepository();
        DodoPizzaApiLiveData = countriesRepository.DodoPizzaApiData();
    }

    public LiveData<List<countries>> getDodoResponseApiData() {
        return DodoPizzaApiLiveData;
    }
}



