package com.pjpratikjain7.countries.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pjpratikjain7.countries.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> countries;

    public CountryListAdapter(Context context, ArrayList<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.country_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String country = countries.get(position);
        holder.textCountryName.setText(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

     static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textCountryName;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCountryName = itemView.findViewById(R.id.textCounrtryName);
        }

    }
}
