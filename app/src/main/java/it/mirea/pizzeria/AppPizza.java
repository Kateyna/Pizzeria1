package it.mirea.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.jar.Attributes;

import it.mirea.pizzeria.databinding.ActivityAddBinding;
import it.mirea.pizzeria.databinding.FragmentNotificationsBinding;

public class AppPizza extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.codinginflow.architectureexample.EXTRA_NAME";
    public static final String EXTRA_PIZZANAME = "com.codinginflow.architectureexample.EXTRA_PIZZANAME";
    public static final String EXTRA_RECEPT = "com.codinginflow.architectureexample.EXTRA_RECEPT";
    private EditText Name;
    private EditText Pizzaname;
    private EditText Receptpizza;
    Button button;
    PizzaViewmodel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Name = (EditText) findViewById(R.id.input_name);
        Pizzaname = (EditText) findViewById(R.id.input_pizzaname);
        Receptpizza = (EditText) findViewById(R.id.input_recept);
        button = (Button) findViewById(R.id.dobavit);
        String name = Name.getText().toString();
        String pizzaname = Pizzaname.getText().toString();
        String recept = Receptpizza.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (name.trim().isEmpty()||pizzaname.trim().isEmpty()|| recept.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please add all",Toast.LENGTH_SHORT).show();
                    return;
                 }
                 Intent data = new Intent();
                 data.putExtra(EXTRA_NAME, name);
                 data.putExtra(EXTRA_PIZZANAME, pizzaname);
                 data.putExtra(EXTRA_RECEPT,recept);
                 setResult(RESULT_OK,data);
                 finish();
            }

        });



    }
}
