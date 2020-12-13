package com.expensexpert.expensexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMember extends AppCompatActivity {

    public EditText input_name, input_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        input_name = findViewById(R.id.new_member_name);
        input_balance = findViewById(R.id.new_member_balance);
    }

    public void addMember(View view) {
        String name = input_name.getText().toString();
        String balance = input_balance.getText().toString();

        Toast.makeText(AddMember.this, "Name: "+name+", Balance: "+balance, Toast.LENGTH_LONG).show();
        finish();
    }
}