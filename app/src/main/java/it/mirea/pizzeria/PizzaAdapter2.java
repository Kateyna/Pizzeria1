package it.mirea.pizzeria;

import android.content.Intent;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import it.mirea.pizzeria.databinding.ItemList2Binding;

public class PizzaAdapter2 extends RecyclerView.Adapter<PizzaAdapter2.MyViewHolder2>{



    private List <pizzas> moli =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemList2Binding binding = ItemList2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder( MyViewHolder2  holder, int position)  {

        pizzas pizzas = moli.get(position);
        Picasso.get().load(pizzas.getImg()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return moli.size();
    }

    public void setPizza2(List<pizzas> oli){
        this.moli = oli;
        notifyDataSetChanged();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        ItemList2Binding binding;

        private TextView nameTxt,pizzaTxt,receptTxt,time;
        private ImageView imageView;

        public MyViewHolder2(ItemList2Binding binding){
            super(binding.getRoot());
            this.binding = binding;

            pizzaTxt = (TextView) binding.getRoot().findViewById(R.id.name_txt);
            nameTxt = (TextView) binding.getRoot().findViewById(R.id.name_txt);
            imageView = (ImageView) binding.getRoot().findViewById(R.id.imageView);


            itemView.findViewById(R.id.buttony2).setOnClickListener(view -> {

                Calendar alarm = new GregorianCalendar(TimeZone.getDefault());

                int hour = alarm.get(Calendar.HOUR_OF_DAY);
                int minutes = alarm.get(Calendar.MINUTE);

                minutes = minutes - 340;

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

    }
}
