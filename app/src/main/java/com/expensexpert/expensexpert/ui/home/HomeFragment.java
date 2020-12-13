package com.expensexpert.expensexpert.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.expensexpert.expensexpert.R;
import com.expensexpert.expensexpert.SingleTour;
import com.expensexpert.expensexpert.Tour;
import com.expensexpert.expensexpert.TourAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements TourAdapter.RecyclerViewClickListener {

    private HomeViewModel homeViewModel;
    private ArrayList<Tour> tourArrayList;
    private RecyclerView recyclerView;
    private TourAdapter.RecyclerViewClickListener listener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = root.findViewById(R.id.tour_list);
        tourArrayList = new ArrayList<>();
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        setTourInfo();
        setAdapter();
        return root;
    }

    private void setAdapter() {
        setOnclickListener();
        TourAdapter adapter = new TourAdapter(tourArrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnclickListener() {
        listener = new TourAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), SingleTour.class);
                intent.putExtra("tourname", tourArrayList.get(position).getTitle());
                startActivity(intent);
            }
        };
    }

    private void setTourInfo() {
        tourArrayList.add(new Tour("Sample Tour 1"));
        tourArrayList.add(new Tour("Sample Tour 2"));
        tourArrayList.add(new Tour("Sample Tour 3"));
        tourArrayList.add(new Tour("Sample Tour 4"));
        tourArrayList.add(new Tour("Sample Tour 5"));
        tourArrayList.add(new Tour("Sample Tour 6"));
        tourArrayList.add(new Tour("Sample Tour 7"));
        tourArrayList.add(new Tour("Sample Tour 8"));
    }

    @Override
    public void onClick(View view, int position) {
        Log.e("works", "works");
        Intent intent = new Intent(getContext(), SingleTour.class);
        intent.putExtra("tourname", tourArrayList.get(position).getTitle());
        startActivity(intent);
    }
}