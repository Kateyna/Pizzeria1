package it.mirea.pizzeria;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PizzaViewmodel extends AndroidViewModel {

    PizzaRepozitory repozitory;
    LiveData<List<Pizza>> pizzaList;

    public PizzaViewmodel (Application application){
        super(application);
        repozitory =  new PizzaRepozitory(application);
        pizzaList = repozitory.getPizza();
    }

    LiveData<List<Pizza>> getAllPizzas(){
        return  pizzaList;
    }

    public  void  insertPizzas(Pizza pizza){
        repozitory.insert(pizza);
    }

}
