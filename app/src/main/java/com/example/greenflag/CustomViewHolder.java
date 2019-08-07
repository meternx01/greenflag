package com.example.greenflag;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView tv_profile_name, tv_profile_username, tv_profile_age, tv_profile_country;

    public CustomViewHolder(@NonNull View itemView) {

        super(itemView);

        tv_profile_name = itemView.findViewById(R.id.tv_profile_name);
        tv_profile_username = itemView.findViewById(R.id.tv_profile_username);
        tv_profile_age  = itemView.findViewById(R.id.tv_profile_age);
        tv_profile_country = itemView.findViewById(R.id.tv_profile_country);
    }
}
