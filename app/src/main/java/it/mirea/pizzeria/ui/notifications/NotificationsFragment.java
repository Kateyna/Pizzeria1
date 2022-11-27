package it.mirea.pizzeria.ui.notifications;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.mirea.pizzeria.AddPizza;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    public static final int ADD_NOTE_REQUEST = 1;
    private Button button;

    Button button2;
    PizzaViewmodel model;
    private FragmentNotificationsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        return rootView;


    }


    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {

        button = view.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You ordered the pizza. Wait for 20 minutes", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(), AddPizza.class);
                startActivityForResult(intent,ADD_NOTE_REQUEST);
            }
        });

    }


    //     button2 = view.findViewById(R.id.deleteButton);

    //   button2.setOnClickListener((View.OnClickListener) this);

    //String PIZZA_NAME = Pizzaname.getText().toString();
   // String PIZZA_RECEPT = Receptpizza.getText().toString();
    //String NAME = Name.getText().toString();
    //Pizza anna = new Pizza(NAME,PIZZA_NAME, PIZZA_RECEPT);
    // model.insert(anna);




    // final TextView textView = binding.textNotification;
    // notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}