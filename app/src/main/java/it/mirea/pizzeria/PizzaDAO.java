package it.mirea.pizzeria;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
    void AddPizza(Pizza pizza);

    @Update
    void UpdatePizza(Pizza pizza);

    @Delete
    void DeletePizza(Pizza pizza);

    @Query("SELECT * FROM pizza")
    LiveData<List<Pizza>> getAllPizzas();

    @Query("select * from pizza where name ==:name ")
    public Pizza getPizza(String name);

    @Query("select * from pizza")
    public LiveData<List<Pizza>> getAllPizzasLive();


}
