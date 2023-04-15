package com.example.myapplication;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class charachterAdapter extends RecyclerView.Adapter<charachterAdapter.ViewHolder> {
    private Charachter charachter ;
    private Context context;

    public charachterAdapter(Charachter charachter, Context context) {
        this.charachter = charachter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_details, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(charachter.getName());
        holder.exp.setText(charachter.getExp());
        holder.hp.setText(charachter.getHp());
        holder.height.setText(charachter.getHeight());
        holder.weight.setText(charachter.getWeight());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView exp;
        private TextView hp;
        private TextView height;
        private TextView weight;
        public ViewHolder(View itemView) {
            super(itemView);

            name =  itemView.findViewById(R.id.charachterName);
            exp =  itemView.findViewById(R.id.EXP);
            hp =  itemView.findViewById(R.id.HP);
            height =  itemView.findViewById(R.id.Height);
            weight =  itemView.findViewById(R.id.Weight);

        }
    }

}
