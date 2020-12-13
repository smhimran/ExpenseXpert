package com.expensexpert.expensexpert;

import android.os.Bundle;
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
        BalanceAdapter adapter = new BalanceAdapter(balanceArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setBalanceInfo() {
        balanceArrayList.add(new Balance("Member 1", 400));
        balanceArrayList.add(new Balance("Member 2", 100));
    }
}
