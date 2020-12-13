package com.expensexpert.expensexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBalance extends AppCompatActivity {

    private EditText added_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);

        added_balance = findViewById(R.id.add_member_balance);
    }

    public void addBalance(View view) {
        String balance = added_balance.getText().toString();

        Toast.makeText(this, "Added Balance : "+balance, Toast.LENGTH_LONG).show();
        finish();
    }
}