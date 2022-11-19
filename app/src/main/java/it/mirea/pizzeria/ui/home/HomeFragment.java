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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import it.mirea.pizzeria.R;
import it.mirea.pizzeria.drinks;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.PizzaAdapter2;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    private PizzaAdapter2 adapter;
    private FragmentHomeBinding binding;
    NewPizzaViewmodel model2;
    Button mButton;
    TextView textView;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PizzaAdapter2();
        model2 = ViewModelProviders.of(this).get(NewPizzaViewmodel.class);
        model2.init();
        model2.getVolumesResponseLiveData().observe(this.getViewLifecycleOwner(), new Observer<drinks>() {
            @Override
            public void onChanged(drinks drinks) {
                if (drinks != null) {
                    adapter.setPizza2(drinks.getItems());
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {





        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();



    }

    public void performSearch() {

    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {



    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}