package com.gmail.gosnellwebdesign.guessinggameranked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalsActivity extends AppCompatActivity {

    // Program variables
    Button buttonTotalsBackToMain;
    TextView textViewNovicesNumber;
    TextView textViewSemiprosNumber;
    TextView textViewExpertsNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        // Widget references
        buttonTotalsBackToMain = findViewById(R.id.buttonTotalsBackToMain);
        textViewNovicesNumber = findViewById(R.id.textViewNovicesNumber);
        textViewSemiprosNumber = findViewById(R.id.textViewSemiprosNumber);
        textViewExpertsNumber = findViewById(R.id.textViewExpertsNumber);

        // Get intent from MainActivity
        Intent intent = getIntent();

        // Rank amount variables
        int numNovices = intent.getIntExtra("numNovices", 0);
        int numSemipros = intent.getIntExtra("numSemipros", 0);
        int numExperts = intent.getIntExtra("numExperts", 0);

        // Set text values to number of plays for each rank
        textViewNovicesNumber.setText(String.valueOf(numNovices));
        textViewSemiprosNumber.setText(String.valueOf(numSemipros));
        textViewExpertsNumber.setText(String.valueOf(numExperts));

        // Back to main activity
        buttonTotalsBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
