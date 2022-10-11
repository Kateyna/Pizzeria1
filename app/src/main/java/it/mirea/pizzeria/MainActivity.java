package it.mirea.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText Pizzaname;
    EditText Receptpizza;
    EditText Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Receptpizza = (EditText) findViewById(R.id.Receptpizza);
        Pizzaname = (EditText) findViewById(R.id.Pizzaname);
        Name = (EditText) findViewById(R.id.Name);



        PizzaViewmodel viewmodel = ViewModelProviders.of(this).get(PizzaViewmodel.class);

        PizzaDatabase db = Room.databaseBuilder(getApplicationContext(),
                PizzaDatabase.class, "pizza-database").allowMainThreadQueries().build();

        Pizza kate = new Pizza("Kate", "karbonara", "chichken,tomato");

        //    db.pizzaDAO().insertAll(anna);

        //    List<Pizza> pizzaList = db.pizzaDAO().getAllPizzas();

        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(view ->  {
            String PIZZA_NAME = Pizzaname.getText().toString();
            String PIZZA_RECEPT = Receptpizza.getText().toString();
            String NAME = Name.getText().toString();
            Pizza anna = new Pizza(NAME,PIZZA_NAME, PIZZA_RECEPT);
            viewmodel.insertPizzas(anna);

            Intent intent = new Intent(MainActivity.this, PizzaSpisok.class);
            startActivity(intent);

            Context context = getApplicationContext();
            CharSequence text = "Поздравляю! Вы создали пиццу!!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Toast.makeText(context, text, duration).show();

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