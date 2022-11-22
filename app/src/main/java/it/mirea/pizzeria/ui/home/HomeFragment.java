package it.mirea.pizzeria.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.mirea.pizzeria.AppPizza;
import it.mirea.pizzeria.Ludi;
import it.mirea.pizzeria.RetroRepository;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.RecyclerList;
import it.mirea.pizzeria.NewPizzaViewmodel;
import it.mirea.pizzeria.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {
    FragmentHomeBinding binding;
    NewPizzaViewmodel model2;
    RetroRepository repoz;
    Button mButton;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    RecyclerView recyclerView;
    ImageView imageView;
    Button button;

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
        button = view.findViewById(R.id.buttonS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You ordered the pizza. Wait for 20 minutes", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(), Ludi.class);
                startActivity(intent);
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