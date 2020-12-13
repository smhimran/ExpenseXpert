package com.expensexpert.expensexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class AddExpense extends AppCompatActivity {

    final String members = "";
    private EditText expense_title, expense_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        LinearLayout checkBoxContainer = findViewById(R.id.checkbox_container);
        expense_title = findViewById(R.id.new_expense_title);
        expense_amount = findViewById(R.id.new_expense_amount);
        CheckBox checkBox;

        ArrayList<String> list = new ArrayList<>();

        list.add("Member 1");
        list.add("Member 2");
        list.add("Member 3");
        list.add("Member 4");
        list.add("Member 5");


        final ArrayList<CheckBox> checkBoxes = new ArrayList<>();

        for (int i=0; i<list.size(); i++) {
            checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText(list.get(i));
            checkBox.setTag(list.get(i));

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Log.e("checked", buttonView.getText().toString());
                        members.concat(buttonView.getText().toString()+", ");
                    }
                }
            });

            checkBoxes.add(checkBox);
            checkBoxContainer.addView(checkBox);
        }
    }

    public void addExpense(View view) {
        Log.e("members", members);
        String amount = expense_amount.getText().toString();
        Toast.makeText(this, members +" "+ amount, Toast.LENGTH_LONG).show();
        finish();
    }
}