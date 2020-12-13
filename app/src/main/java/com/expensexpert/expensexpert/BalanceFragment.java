package com.expensexpert.expensexpert;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BalanceFragment extends Fragment {


    private ArrayList<Balance> balanceArrayList;
    private RecyclerView recyclerView;
    private BalanceAdapter.RecyclerViewClickListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_balance, container, false);


        recyclerView = root.findViewById(R.id.balance_list);
        balanceArrayList = new ArrayList<>();

        setBalanceInfo();
        setAdapter();
        return root;
    }

    private void setAdapter() {
        setOnclickListener();
        BalanceAdapter adapter = new BalanceAdapter(balanceArrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnclickListener() {
        listener = new BalanceAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), AddBalance.class);
                intent.putExtra("member_name", balanceArrayList.get(position).getName());
                startActivity(intent);
            }
        };
    }


    private void setBalanceInfo() {
        balanceArrayList.add(new Balance("Member 1", 400));
        balanceArrayList.add(new Balance("Member 2", 100));
    }


    public void onClick(View view, int position) {
        Log.e("works", "works");
        Intent intent = new Intent(getContext(), AddBalance.class);
        intent.putExtra("member_name", balanceArrayList.get(position).getName());
        startActivity(intent);
    }
}
