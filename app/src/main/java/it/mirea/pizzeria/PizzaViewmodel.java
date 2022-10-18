package it.mirea.pizzeria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PizzaViewmodel extends AndroidViewModel {

    private PizzaRepozitory repozitory;
    private LiveData<List<Pizza>> pizzaList;

    public PizzaViewmodel(@NonNull Application application) {
        super(application);
        repozitory = new PizzaRepozitory(application);
        pizzaList = repozitory.getAllPizzas();
    }


    public void insert(Pizza pizza){ repozitory.insert(pizza); }

    public void update(Pizza pizza){
        repozitory.update(pizza);
    }

    public void delete(Pizza pizza){
        repozitory.delete(pizza);
    }

    public LiveData<List<Pizza>> getAllPizzas(){
        return pizzaList;
    }
}
