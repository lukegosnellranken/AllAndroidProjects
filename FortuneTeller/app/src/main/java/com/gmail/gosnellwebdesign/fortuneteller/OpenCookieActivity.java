package com.gmail.gosnellwebdesign.fortuneteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpenCookieActivity extends AppCompatActivity {

    //Program variables
    Button buttonBackToMain;
    TextView textViewFortune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_cookie);

        // Widget references
        buttonBackToMain = findViewById(R.id.buttonBackToMain);
        textViewFortune = findViewById(R.id.textViewFortune);

        // Get intent from MainActivity
        Intent intent = getIntent();
        String randomFortune = intent.getStringExtra("randomFortune");

        // Set text widget to the user's fortune
        textViewFortune.setText(randomFortune);

        // Send user back to MainActivity view when button is tapped
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
