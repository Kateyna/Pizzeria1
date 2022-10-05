package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PizzaDAO {
   // @Insert
    //  void addPizza(PizzaDTO pizza);

    //  @Delete
    // void deletePizza(PizzaDTO pizza);

    //@Query("SELECT * FROM pizza")
    // LiveData<List<PizzaDTO>> getAllPizzas();

    @Insert
    void insertAll(Pizza... pizzas);

    @Query("SELECT * FROM pizza")
    LiveData<List<Pizza>>getAllPizzas();
}
