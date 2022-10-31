package it.mirea.pizzeria;

import android.content.Intent;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

import it.mirea.pizzeria.databinding.ItemListBinding;


public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder>{



    private List<Pizza> mPizzas =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)  {

        Pizza pizza = mPizzas.get(position);
        holder.bindView(pizza);

    }

    @Override
    public int getItemCount() {
        return mPizzas.size();
    }

    public void setPizza(List<Pizza> pizza){
        this.mPizzas = pizza;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding binding;

        TextView nameTxt,pizzaTxt,receptTxt,time;


        public MyViewHolder(ItemListBinding binding){
            super(binding.getRoot());
            this.binding = binding;


            itemView.findViewById(R.id.buttony).setOnClickListener(view -> {

                Calendar alarm = new GregorianCalendar(TimeZone.getDefault());

                int hour = alarm.get(Calendar.HOUR_OF_DAY);
                int minutes = alarm.get(Calendar.MINUTE);

                minutes = minutes - 400;

                Toast.makeText(itemView.getContext(), "You ordered the pizza. Wait for 20 minutes", Toast.LENGTH_SHORT).show();
                Date date = new Date();
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String timeText = timeFormat.format(date);
                intent.putExtra(AlarmClock.EXTRA_HOUR,0);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Pizza is done");
                view.getContext().startActivity(intent);

            });

        }
        public void bindView(Pizza pizza){

            binding.nameTxt.setText(pizza.getName());
            binding.pizzaTxt.setText(pizza.getPizza_name());
            binding.receptTxt.setText(pizza.getRecept());
        }
    }
}
