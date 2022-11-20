package it.mirea.pizzeria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import java.util.ArrayList;
import java.util.List;

import it.mirea.pizzeria.databinding.ItemList2Binding;
import it.mirea.pizzeria.databinding.ItemListBinding;

public class PizzaAdapter2 extends RecyclerView.Adapter<PizzaAdapter2.MyViewHolder2> {
    private List<list> results = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemList2Binding binding = ItemList2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        list list = results.get(position);
        holder.titleTextView.setText(list.getName2());
        holder.bindView(list);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<list> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
         TextView titleTextView;
         ItemList2Binding binding;


        public MyViewHolder2(ItemList2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;


            titleTextView = itemView.findViewById(R.id.drink_txt);
        }

        public void bindView(list list){

            binding.drinkTxt.setText(list.getCode());

        }

    }

}