package com.expensexpert.expensexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.MyViewHolder> {

    private ArrayList<Balance> balancelist;

    public BalanceAdapter(ArrayList<Balance> balancelist) {
        this.balancelist = balancelist;
    }


    @Override
    public void onBindViewHolder(@NonNull BalanceAdapter.MyViewHolder holder, int position) {
        String name = balancelist.get(position).getName();
        int amount = balancelist.get(position).getAmount();

        holder.name.setText(name);
        holder.amount.setText(Integer.toString(amount));
    }

    @Override
    public int getItemCount() {
        return balancelist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.member_name);
            amount = itemView.findViewById(R.id.member_balance);
        }
    }

    @NonNull
    @Override
    public BalanceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.balance_item, parent, false);

        return new MyViewHolder(itemView);
    }

}
