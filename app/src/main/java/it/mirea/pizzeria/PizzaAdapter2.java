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



    private List <drinks> moli =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemList2Binding binding = ItemList2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder( MyViewHolder2  holder, int position)  {

        drinks drinks = moli.get(position);
        holder.bindView(drinks);



    }

    @Override
    public int getItemCount() {
        return moli.size();
    }

    public void setPizza2(List<drinks> oli){
        this.moli = oli;
        notifyDataSetChanged();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        ItemList2Binding binding;
        private TextView drinks;
        private ImageView imageView;

        public MyViewHolder2(ItemList2Binding binding){
            super(binding.getRoot());
            this.binding = binding;


            drinks = (TextView)binding.getRoot().findViewById(R.id.drink_txt);




        }

        public void bindView(drinks drinks){
            binding.drinkTxt.setText(drinks.getStrDrink());

        }

    }


}
