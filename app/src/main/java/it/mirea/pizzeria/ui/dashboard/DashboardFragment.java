package it.mirea.pizzeria.ui.dashboard;

import static android.app.Activity.RESULT_OK;


import static it.mirea.pizzeria.ui.notifications.NotificationsFragment.ADD_NOTE_REQUEST;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import it.mirea.pizzeria.AddPizza;
import it.mirea.pizzeria.Pizza;
import it.mirea.pizzeria.PizzaAdapter;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.databinding.FragmentDashboardBinding;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    PizzaViewmodel model;
    Button mButton;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        model = new ViewModelProvider(this).get(PizzaViewmodel.class);
        binding.PizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaRecycler.setHasFixedSize(true);
        PizzaAdapter pizzaAdapter = new PizzaAdapter();
        binding.PizzaRecycler.setAdapter(pizzaAdapter);
        model.getAllPizzas().observe(getViewLifecycleOwner(), new Observer<List<Pizza>>() {
            @Override
            public void onChanged(List<Pizza> pizzas) {
                pizzaAdapter.setPizza(pizzas);
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(AddPizza.EXTRA_NAME);
            String pizzaname = data.getStringExtra(AddPizza.EXTRA_PIZZANAME);
            String recept = data.getStringExtra(AddPizza.EXTRA_RECEPT);

            Pizza pizza = new Pizza(0,name,pizzaname,recept);
            model.insert(pizza);
            Toast.makeText(getContext(),"Notesavcd",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(),"цфвфц",Toast.LENGTH_SHORT).show();
        }

    }

    //  final TextView textView = binding.textDashboard;
    //  dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}