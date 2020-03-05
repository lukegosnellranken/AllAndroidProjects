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

        buttonBackToMain = findViewById(R.id.buttonBackToMain);
        textViewFortune = findViewById(R.id.textViewFortune);

        Intent intent = getIntent();
        String randomFortune = intent.getStringExtra("randomFortune");

        textViewFortune.setText(randomFortune);

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
