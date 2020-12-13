package com.expensexpert.expensexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.MyViewHolder> {

    private ArrayList<Expense> expenselist;

    public ExpenseAdapter(ArrayList<Expense> expenselist) {
        this.expenselist = expenselist;
    }


    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.MyViewHolder holder, int position) {
        String title = expenselist.get(position).getTitle();
        int amount = expenselist.get(position).getAmount();

        holder.title.setText(title);
        holder.amount.setText(Integer.toString(amount));
    }

    @Override
    public int getItemCount() {
        return expenselist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.member_name);
            amount = itemView.findViewById(R.id.member_balance);
        }
    }

    @NonNull
    @Override
    public ExpenseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.balance_item, parent, false);

        return new MyViewHolder(itemView);
    }

}
