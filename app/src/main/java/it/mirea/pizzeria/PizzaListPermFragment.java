package it.mirea.pizzeria;

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

import it.mirea.pizzeria.databinding.FragmentDashboardBinding;
import it.mirea.pizzeria.databinding.FragmentPizzaListPermFragmentBinding;


public class PizzaListPermFragment extends Fragment {

    FragmentPizzaListPermFragmentBinding binding;
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
        binding = FragmentPizzaListPermFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        model = new ViewModelProvider(this).get(PizzaViewmodel.class);
        binding.PizzaPermRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaPermRecycler.setHasFixedSize(true);
        PizzaPermAdapter pizzaPermAdapter = new PizzaPermAdapter();
        binding.PizzaPermRecycler.setAdapter(pizzaPermAdapter);
        model.getAllPizzas().observe(getViewLifecycleOwner(), new Observer<List<Pizza>>() {
            @Override
            public void onChanged(List<Pizza> pizzas) {
                pizzaPermAdapter.setPizza(pizzas);
            }
        });



    }



    //  final TextView textView = binding.textDashboard;
    //  dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}