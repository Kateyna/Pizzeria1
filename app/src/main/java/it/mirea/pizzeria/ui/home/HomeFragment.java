package it.mirea.pizzeria.ui.home;

import android.os.Bundle;
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

import java.util.List;

import it.mirea.pizzeria.Pizza;
import it.mirea.pizzeria.PizzaAdapter;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.pizzas;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    private PizzaAdapter2 adapter;
    private FragmentHomeBinding binding;
    NewPizzaViewmodel model2;
    Button mButton;
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {




        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {

        adapter = new PizzaAdapter2();

        model2 = ViewModelProviders.of(this).get(NewPizzaViewmodel.class);
        model2.init();
        model2.getVolumesResponseLiveData().observe(this.getViewLifecycleOwner(), new Observer<pizzas>() {
            @Override
            public void onChanged(pizzas pizzas) {
                adapter.setPizza2(pizzas.getItems());
            }
        });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}