package com.gmail.gosnellwebdesign.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextBillAmount;
    EditText editTextTip;
    EditText editTextTotal;
    SeekBar seekBarTipAmount;
    Toast t;
    /*Button buttonTenPercent;
    Button buttonFifteenPercent;
    Button buttonTwentyPercent;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTip = findViewById(R.id.editTextTip);
        editTextTotal = findViewById(R.id.editTextTotal);
        /*buttonTenPercent = findViewById(R.id.buttonTenPercent);
        buttonFifteenPercent = findViewById(R.id.buttonFifteenPercent);
        buttonTwentyPercent = findViewById(R.id.buttonTwentyPercent);*/
        seekBarTipAmount = findViewById(R.id.seekBarTipAmount);

        seekBarTipAmount.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    // Calculate tip amount when user lets go of slider
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        calculateTotals(seekBarTipAmount.getProgress());
                    }
                }
        );



        /*buttonTenPercent.setOnClickListener(new View.OnClickListener() {
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
        */
    }

    void calculateTotals(int percentage){
        double billAmount = Double.valueOf(editTextBillAmount.getText().toString());
        double tip = billAmount * (percentage/100.0);
        double total = billAmount + tip;

        // Set text boxes to tip amount and total
        editTextTip.setText(String.format("$%.2f", tip));
        editTextTotal.setText(String.format("$%.2f", total));

        // Build toast
        t  = Toast.makeText(getApplicationContext(), "The Current Tip Percentage is: " + percentage + "%", android.widget.Toast.LENGTH_LONG);
        t.show();
    }
}
