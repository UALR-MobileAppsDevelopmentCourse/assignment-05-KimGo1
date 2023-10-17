package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButton;

import com.ualr.layoutassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        MaterialButtonToggleGroup materialButtonToggleGroup = findViewById(R.id.materialButtonToggleGroup);

        materialButtonToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (checkedId == R.id.toggleButtonNoDiscount && isChecked) {

                materialButtonToggleGroup.check(R.id.toggleButtonNoDiscount);
                materialButtonToggleGroup.uncheck(R.id.toggleButtonDiscount);
            } else if (checkedId == R.id.toggleButtonDiscount && isChecked) {
                // Set your desired text for the buttons, including the discount
                materialButtonToggleGroup.check(R.id.toggleButtonDiscount);
                materialButtonToggleGroup.uncheck(R.id.toggleButtonNoDiscount);
            }
        });


    }
}