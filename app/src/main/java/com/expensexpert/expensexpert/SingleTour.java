package com.expensexpert.expensexpert;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SingleTour extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_tour);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        String title = "No Title";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            title = extras.getString("tourname");
        }

        getSupportActionBar().setTitle(title);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_host_fragment, new BalanceFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_balance:
                    fragment = new BalanceFragment();
                    break;
                case R.id.navigation_expense:
                    fragment = new ExpenseFragment();
                    break;
                case R.id.navigation_members:
                    fragment = new MemberFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_host_fragment, fragment).commit();
            return true;
        }
    };
}
