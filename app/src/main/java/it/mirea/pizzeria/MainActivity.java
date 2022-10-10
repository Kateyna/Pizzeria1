package it.mirea.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static    String PIZZA_NAME = "recept";
    private static final   String PIZZA_RECEPT = "recept";
    EditText Pizzaname;
    EditText Receptpizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Receptpizza = (EditText) findViewById(R.id.Receptpizza);
        Pizzaname = (EditText) findViewById(R.id.Pizzaname);



        PizzaViewmodel viewmodel = ViewModelProviders.of(this).get(PizzaViewmodel.class);

        PizzaDatabase db = Room.databaseBuilder(getApplicationContext(),
                PizzaDatabase.class, "pizza-database").allowMainThreadQueries().build();

        EditText Pizzaname =  (EditText) findViewById(R.id.Pizzaname);



        PIZZA_NAME = Pizzaname.getText().toString();

        Pizza anna = new Pizza("Ana", PIZZA_NAME, PIZZA_RECEPT);

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