package com.ualr.layoutassignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.TextAppearanceInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButton;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

double discountpercent=1.00;
    private TextAppearanceInfo.Builder materialButton;
    private TextAppearanceInfo.Builder toggleButtonDiscount;

    private void calculateTotal() {
    double total = 0;

    CheckBox checkBox1 = findViewById(R.id.checkBox1);
    CheckBox checkBox2 = findViewById(R.id.checkBox2);
    CheckBox checkBox3 = findViewById(R.id.checkBox3);
    CheckBox checkBox4 = findViewById(R.id.checkBox4);

    EditText editTextNumberDecimal1 = findViewById(R.id.editTextNumberDecimal1);
    EditText editTextNumberDecimal2 = findViewById(R.id.editTextNumberDecimal2);
    EditText editTextNumberDecimal3 = findViewById(R.id.editTextNumberDecimal3);
    EditText editTextNumberDecimal4 = findViewById(R.id.editTextNumberDecimal4);

    if (checkBox1.isChecked()) {
        total += Double.parseDouble(editTextNumberDecimal1.getText().toString());
    }
    if (checkBox2.isChecked()) {
        total += Double.parseDouble(editTextNumberDecimal2.getText().toString());
    }
    if (checkBox3.isChecked()) {
        total += Double.parseDouble(editTextNumberDecimal3.getText().toString());
    }
    if (checkBox4.isChecked()) {
        total += Double.parseDouble(editTextNumberDecimal4.getText().toString());
    }

        total *= discountpercent ; // Applying 20% discount


    // total amount
    EditText editTextNumberDecimalTotal = findViewById(R.id.editTextNumberDecimalTotal);
    editTextNumberDecimalTotal.setText(String.format("$ %.2f", total));
    }
    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label




    private ActivityMainBinding mBinding;

    @RequiresApi(api = 34)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        MaterialButtonToggleGroup materialButtonToggleGroup = findViewById(R.id.DiscountGroup);

        materialButtonToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (checkedId == R.id.toggleButtonNoDiscount && isChecked) {

                materialButtonToggleGroup.check(R.id.toggleButtonNoDiscount);
                materialButtonToggleGroup.uncheck(R.id.toggleButtonDiscount);
                discountpercent = 1.00;
            } else if (checkedId == R.id.toggleButtonDiscount && isChecked) {
                // Set your desired text for the buttons, including the discount
                materialButtonToggleGroup.check(R.id.toggleButtonDiscount);
                materialButtonToggleGroup.uncheck(R.id.toggleButtonNoDiscount);
                discountpercent = 0.80;
            }
        });

        MaterialButtonToggleGroup CalculateGroup = findViewById(R.id.CalculateGroup);
        MaterialButton toggleButtonCalculate = findViewById(R.id.toggleButtonCalculate);
        toggleButtonCalculate.setOnClickListener(v -> {
            calculateTotal();
        });

    }
}