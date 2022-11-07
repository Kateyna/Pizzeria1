package it.mirea.pizzeria.ui.home;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import it.mirea.pizzeria.DetailApiResponce;
import it.mirea.pizzeria.Pizza;
import it.mirea.pizzeria.PizzaAdapter;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {

    private FragmentHomeBinding binding;
    PizzaViewmodel model;
    Button mButton;
    TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {

        binding.PizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaRecycler.setHasFixedSize(true);
        PizzaAdapter2 pizzaAdapter2 = new PizzaAdapter2();
        binding.PizzaRecycler.setAdapter(pizzaAdapter2);
       // model.getData().observe(getViewLifecycleOwner(), new Observer<List<DetailApiResponce>>() {
      //      @Override
     //       public void onChanged(List<DetailApiResponce> string) {
    //            pizzaAdapter2.setPizza2(string);
   //         }
    //    });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}