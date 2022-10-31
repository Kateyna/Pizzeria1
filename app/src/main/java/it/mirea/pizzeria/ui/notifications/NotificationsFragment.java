package it.mirea.pizzeria.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import it.mirea.pizzeria.MainActivity;
import it.mirea.pizzeria.Pizza;
import it.mirea.pizzeria.PizzaViewmodel;
import it.mirea.pizzeria.R;
import it.mirea.pizzeria.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    EditText Pizzaname;
    EditText Receptpizza;
    EditText Name;
    Button button;
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
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {


   //     button = view.findViewById(R.id.addButton);
   //     button2 = view.findViewById(R.id.deleteButton);
    //    button.setOnClickListener((View.OnClickListener) this);
     //   button2.setOnClickListener((View.OnClickListener) this);



    }

    //String PIZZA_NAME = Pizzaname.getText().toString();
    //String PIZZA_RECEPT = Receptpizza.getText().toString();
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