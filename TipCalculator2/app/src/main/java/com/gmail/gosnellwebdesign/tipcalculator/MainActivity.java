package com.gmail.gosnellwebdesign.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextBillAmount;
    EditText editTextTip;
    EditText editTextTotal;
    Button buttonTenPercent;
    Button buttonFifteenPercent;
    Button buttonTwentyPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTip = findViewById(R.id.editTextTip);
        editTextTotal = findViewById(R.id.editTextTotal);
        buttonTenPercent = findViewById(R.id.buttonTenPercent);
        buttonFifteenPercent = findViewById(R.id.buttonFifteenPercent);
        buttonTwentyPercent = findViewById(R.id.buttonTwentyPercent);

        buttonTenPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculateTotals(0.10);
            }
        });

        buttonFifteenPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculateTotals(0.15);
            }
        });

        buttonTwentyPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculateTotals(0.20);
            }
        });

    }

    void calculateTotals(Double percentage){
        double billAmount = Double.valueOf(editTextBillAmount.getText().toString());
        double tip = billAmount * percentage;
        double total = billAmount + tip;

        editTextTip.setText(String.format("$%.2f", tip));
        editTextTotal.setText(String.format("$%.2f", total));
    }
}
