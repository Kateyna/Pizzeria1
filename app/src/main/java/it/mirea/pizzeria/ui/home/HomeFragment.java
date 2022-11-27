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

import it.mirea.pizzeria.CountriesAdapter;
import it.mirea.pizzeria.CountriesRepository;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.CountriesViewmodel;
import it.mirea.pizzeria.countries;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    CountriesAdapter adapter;
    FragmentHomeBinding binding;
    CountriesViewmodel model2;
    CountriesRepository repoz;
    Button mButton;
    TextView TextViewcode;
    TextView TextViewid;
    TextView TextViewName;
    TextView TextViewCurrency;
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
        recyclerView = view.findViewById(R.id.CountriesRecycler);
        TextViewcode = view.findViewById(R.id.codeTxt);
        TextViewid = view.findViewById(R.id.idTxt);
        TextViewName = view.findViewById(R.id.nameTxt);
        TextViewCurrency = view.findViewById(R.id.CurrencyTxt);
        adapter = new CountriesAdapter();
        model2 = new ViewModelProvider(this).get(CountriesViewmodel.class);
        model2.init();
        binding.CountriesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.CountriesRecycler.setAdapter(adapter);
        model2.getDodoResponseApiData().observe(getViewLifecycleOwner(), new Observer<List<countries>>() {
            @Override
            public void onChanged(List<countries> countries) {
                adapter.setCountries(countries);
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