package com.example.greenflag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Profile> dataSet;

    public CustomAdapter(List<Profile> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_profile_name.setText(dataSet.get(position).name);
        holder.tv_profile_username.setText(dataSet.get(position).userName);
        holder.tv_profile_age.setText(dataSet.get(position).age);
        holder.tv_profile_country.setText(dataSet.get(position).country);
    }

    @Override
    public int getItemCount() {
        if (dataSet == null) {
            return 0;
        } else {
            return dataSet.size();
        }
    }

}
