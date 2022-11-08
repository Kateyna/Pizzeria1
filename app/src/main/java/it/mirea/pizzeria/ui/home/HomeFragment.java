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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import it.mirea.pizzeria.DetailApiResponce;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.Pizza;
import it.mirea.pizzeria.PizzaAdapter;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    private PizzaAdapter2 adapter;
    private FragmentHomeBinding binding;
    NewPizzaViewmodel model;
    Button mButton;
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PizzaAdapter2();

        model = ViewModelProviders.of(this).get(NewPizzaViewmodel.class);
        model.init();
        model.getVolumesResponseLiveData().observe(this, new Observer<DetailApiResponce>() {
            @Override
            public void onChanged(DetailApiResponce detailApiResponce) {
                if (detailApiResponce != null) {
          //          adapter.setResults(detailApiResponce.getItems());
                }
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);



        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated( @NonNull View view, @Nullable Bundle savedInstanceState) {


        model = new ViewModelProvider(this).get(NewPizzaViewmodel.class);
        binding.PizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaRecycler.setHasFixedSize(true);
        PizzaAdapter2 pizzaAdapter2 = new PizzaAdapter2();
        binding.PizzaRecycler.setAdapter(pizzaAdapter2);
        model.getVolumesResponseLiveData();

    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}