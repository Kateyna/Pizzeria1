package it.mirea.pizzeria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;
import java.util.ArrayList;



public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder>{

    private List<Pizza> mPizzas =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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

        public MyViewHolder(ItemListBinding binding){
            super(binding.getRoot());
            this.binding = binding;


        }
        public void bindView(Pizza pizza){
            binding.nameTxt.setText(pizza.getTheme());
        }
    }
}
