package com.pjpratikjain7.countries.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pjpratikjain7.countries.R;
import com.pjpratikjain7.countries.model.Country;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class RegionListAdapter extends RecyclerView.Adapter<RegionListAdapter.ViewHolder> {

    private Context context;
    private List<String> regions;
    private ViewHolder.OnRegionListener onRegionListener;

    public RegionListAdapter(Context context, List<String> regions, ViewHolder.OnRegionListener onRegionListener) {
        Toast.makeText(context, "RggionAdapterCalled", Toast.LENGTH_SHORT).show();
        this.context = context;
        this.regions = regions;
        this.onRegionListener = onRegionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new ViewHolder(inflater.inflate(R.layout.region_list_item, parent, false), onRegionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String region = regions.get(position);
        holder.textRegionName.setText(region);
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textRegionName;
        OnRegionListener   onRegionListener;
        public ViewHolder(@NonNull View itemView, OnRegionListener onRegionListener) {
            super(itemView);
            textRegionName = itemView.findViewById(R.id.textRegionName);
            this.onRegionListener = onRegionListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onRegionListener.onRegionClick(getAdapterPosition());
        }

        public interface OnRegionListener{

            void onRegionClick(int position);
        }
    }
}
