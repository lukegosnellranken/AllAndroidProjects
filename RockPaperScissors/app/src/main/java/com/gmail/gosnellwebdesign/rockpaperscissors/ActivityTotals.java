package com.gmail.gosnellwebdesign.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTotals extends AppCompatActivity {

    //Program variables
    Button buttonBackToMain;
    TextView textViewComputerWinsDisplay;
    TextView textViewUserWinsDisplay;
    TextView textViewTiesDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        buttonBackToMain = findViewById(R.id.buttonBackToMain);
        textViewComputerWinsDisplay = findViewById(R.id.textViewComputerWinsDisplay);
        textViewUserWinsDisplay = findViewById(R.id.textViewUserWinsDisplay);
        textViewTiesDisplay = findViewById(R.id.textViewTiesDisplay);

        //Get intent
        Intent intent = getIntent();
        int numComputerWins = intent.getIntExtra("numComputerWins", 0);
        int numUserWins = intent.getIntExtra("numUserWins", 0);
        int numTies = intent.getIntExtra("numTies", 0);

        textViewComputerWinsDisplay.setText(String.valueOf(numComputerWins));
        textViewUserWinsDisplay.setText(String.valueOf(numUserWins));
        textViewTiesDisplay.setText(String.valueOf(numTies));

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
