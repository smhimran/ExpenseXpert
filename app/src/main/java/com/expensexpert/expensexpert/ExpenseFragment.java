package com.expensexpert.expensexpert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ExpenseFragment extends Fragment {

    private ArrayList<Expense> expenseArrayList;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expense, container, false);


        recyclerView = root.findViewById(R.id.expense_list);
        expenseArrayList = new ArrayList<>();
        fab = root.findViewById(R.id.add_expense);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setexpenseInfo();
        setAdapter();
        return root;
    }

    private void setAdapter() {
        ExpenseAdapter adapter = new ExpenseAdapter(expenseArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setexpenseInfo() {
        expenseArrayList.add(new Expense("Expense 1", 400));
        expenseArrayList.add(new Expense("Expense 2", 100));
    }
}
