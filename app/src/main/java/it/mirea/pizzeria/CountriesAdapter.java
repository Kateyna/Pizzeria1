package it.mirea.pizzeria;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.mirea.pizzeria.databinding.ItemCountriesListBinding;


public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {
    private List<countries> mCountries = new ArrayList<>();

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountriesListBinding binding =  ItemCountriesListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        countries countries = mCountries.get(position);
        holder.bindView(countries);
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    public void setCountries(List<countries> mCountries) {
        this.mCountries = mCountries;
        notifyDataSetChanged();
    }


    public static class CountriesViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView,titleTextView1,titleTextView2,titleTextView3;
        ItemCountriesListBinding binding;


        public CountriesViewHolder( ItemCountriesListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            titleTextView2 = itemView.findViewById(R.id.codeTxt);
            titleTextView1 = itemView.findViewById(R.id.idTxt);
            titleTextView = itemView.findViewById(R.id.nameTxt);
            titleTextView3 = itemView.findViewById(R.id.CurrencyTxt);
        }

        public void bindView(countries countries){

            binding.codeTxt.setText(countries.getCode());
            binding.idTxt.setText(String.valueOf(countries.getId2()));
            binding.nameTxt.setText(countries.getCountries());
            binding.CurrencyTxt.setText(countries.getCurrency());
        }

    }

}