package it.mirea.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PizzaViewmodel viewmodel = ViewModelProviders.of(this).get(PizzaViewmodel.class);

        PizzaDatabase db = Room.databaseBuilder(getApplicationContext(),
                PizzaDatabase.class, "pizza-database").allowMainThreadQueries().build();

        Pizza anna = new Pizza("Ana", "Anna's pizza", "onion, chicken, barbecue sause");

        Pizza kate = new Pizza("Kate", "karbonara", "chichken,tomato");

        //    db.pizzaDAO().insertAll(anna);

        //    List<Pizza> pizzaList = db.pizzaDAO().getAllPizzas();

        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(view ->  {
            viewmodel.insertPizzas(anna);
        });




        viewmodel.getAllPizzas().observe(this, pizzaList -> {

           // if(pizzaList == null){
             //   return;
            //}

            for (Pizza list : pizzaList) {
                Log.d("pizzas", list.name + " " + list.pizza_name + " " + list.recept);

            }
        });
    }
}