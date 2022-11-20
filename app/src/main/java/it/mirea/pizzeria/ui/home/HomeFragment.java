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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.mirea.pizzeria.R;
import it.mirea.pizzeria.list;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    PizzaAdapter2 adapter;
    FragmentHomeBinding binding;
    NewPizzaViewmodel model2;
    Button mButton;
    TextView textView;
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
        RecyclerView PizzaRecycler = view.findViewById(R.id.PizzaRecycler);
        model2 = new ViewModelProvider(this).get(NewPizzaViewmodel.class);
        model2.init();
        binding.PizzaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.PizzaRecycler.setAdapter(adapter);
        model2.getVolumesResponseLiveData().observe(getViewLifecycleOwner(), new Observer<List<list>>() {
            @Override
            public void onChanged(List<list> list) {
                adapter.setResults(list);
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