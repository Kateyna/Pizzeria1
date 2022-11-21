package it.mirea.pizzeria;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.mirea.pizzeria.databinding.ItemList2Binding;

public class PizzaAdapter2 extends RecyclerView.Adapter<PizzaAdapter2.MyViewHolder2> {
    private List<countries> results = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemList2Binding binding = ItemList2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        countries countries = results.get(position);
        holder.titleTextView.setText(countries.getName2());
        holder.bindView(countries);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<countries> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
         TextView titleTextView,titleTextView1,titleTextView2;
         ItemList2Binding binding;


        public MyViewHolder2(ItemList2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;


            titleTextView2 = itemView.findViewById(R.id.drink_txt3);

            titleTextView1 = itemView.findViewById(R.id.drink_txt2);
            titleTextView = itemView.findViewById(R.id.drink_txt);
        }

        public void bindView(countries countries){

            binding.drinkTxt.setText(countries.getCode());
            binding.drinkTxt2.setText(countries.getId2());
            binding.drinkTxt3.setText(countries.getName2());
            binding.drinkTxt4.setText(countries.getCurrency());
        }

    }

}