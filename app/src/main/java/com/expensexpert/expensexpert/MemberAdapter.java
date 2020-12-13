package com.expensexpert.expensexpert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder> {

    private ArrayList<Member> memberlist;

    public MemberAdapter(ArrayList<Member> Memberlist) {
        this.memberlist = Memberlist;
    }


    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.MyViewHolder holder, int position) {
        String name = memberlist.get(position).getName();
        int balance = memberlist.get(position).getBalance();
        int expense = memberlist.get(position).getExpense();

        holder.name.setText(name);
        holder.balance.setText(Integer.toString(balance));
        holder.expense.setText(Integer.toString(expense));
    }

    @Override
    public int getItemCount() {
        return memberlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, balance, expense;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_member_name);
            expense = itemView.findViewById(R.id.list_member_expense);
            balance = itemView.findViewById(R.id.list_member_balance);
        }
    }

    @NonNull
    @Override
    public MemberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item, parent, false);

        return new MyViewHolder(itemView);
    }

}
