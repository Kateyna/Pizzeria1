package it.mirea.pizzeria.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.mirea.pizzeria.PizzaAddressAnalysis;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.countries;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    PizzaAdapter2 adapter;
    FragmentHomeBinding binding;
    NewPizzaViewmodel model2;
    PizzaAddressAnalysis repoz;
    Button mButton;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.drink_txt);
        recyclerView = view.findViewById(R.id.PizzaRecycler);
        textView2 = view.findViewById(R.id.drink_txt2);
        textView3 = view.findViewById(R.id.drink_txt3);
        textView4 = view.findViewById(R.id.drink_txt4);
        model2 = new ViewModelProvider(this).get(NewPizzaViewmodel.class);
        model2.init();
        binding.PizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaRecycler.setAdapter(adapter);
        model2.getVolumesResponseLiveData().observe(getViewLifecycleOwner(), new Observer<List<countries>>() {
            @Override
            public void onChanged(List<countries> countries) {
                adapter.setResults(countries);
            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}