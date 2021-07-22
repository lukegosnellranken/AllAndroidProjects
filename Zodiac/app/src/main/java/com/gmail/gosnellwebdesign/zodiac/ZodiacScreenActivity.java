package com.gmail.gosnellwebdesign.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ZodiacScreenActivity extends AppCompatActivity {
    // Program constants

    // Program variables
    ImageView imageViewSign;
    TextView textViewUserBirthDate;
    TextView textViewUserBirthday;
    TextView textViewUserAge;
    TextView textViewAbout;
    Button buttonBack;
    String outputStr;

    int inputtedMonth;
    int inputtedDay;
    int inputtedYear;
    String validatedMonth;
    String validatedDay;
    String validatedYear;
    boolean isDateValid = false;
    String fullInputtedDate;
    String userWeekday = "";
    String userAge;
    String sign = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_screen);

        // Widget references
        imageViewSign = findViewById(R.id.imageViewSign);
        textViewUserBirthDate = findViewById(R.id.textViewUserBirthDate);
        textViewUserBirthday = findViewById(R.id.textViewUserBirthday);
        textViewUserAge = findViewById(R.id.textViewUserAge);
        textViewAbout = findViewById(R.id.textViewAbout);
        buttonBack = findViewById(R.id.buttonBack);

        // Get intent
        Intent intent = getIntent();
        String fullInputtedDate = intent.getExtras().getString("fullInputtedDate");
        String userWeekday = intent.getExtras().getString("userWeekday");
        String userAge = intent.getExtras().getString("userAge");
        String sign = intent.getExtras().getString("sign");

        textViewUserBirthDate.setText(fullInputtedDate);
        textViewUserBirthday.setText(userWeekday);
        textViewUserAge.setText(userAge);

        // Check for each sign and display image and text
        if (sign.equals("aquarius")){
            imageViewSign.setImageResource(R.drawable.aquarius);
            textViewAbout.setText(getString(R.string.aquariusInfo));
        }
        else if (sign.equals("pisces")){
            imageViewSign.setImageResource(R.drawable.pisces);
            textViewAbout.setText(getString(R.string.piscesInfo));
        }
        else if (sign.equals("aries")){
            imageViewSign.setImageResource(R.drawable.aries);
            textViewAbout.setText(getString(R.string.ariesInfo));
        }
        else if (sign.equals("taurus")){
            imageViewSign.setImageResource(R.drawable.taurus);
            textViewAbout.setText(getString(R.string.taurusInfo));
        }
        else if (sign.equals("gemini")){
            imageViewSign.setImageResource(R.drawable.gemini);
            textViewAbout.setText(getString(R.string.geminiInfo));
        }
        else if (sign.equals("cancer")){
            imageViewSign.setImageResource(R.drawable.cancer);
            textViewAbout.setText(getString(R.string.cancerInfo));
        }
        else if (sign.equals("leo")){
            imageViewSign.setImageResource(R.drawable.leo);
            textViewAbout.setText(getString(R.string.leoInfo));
        }
        else if (sign.equals("virgo")){
            imageViewSign.setImageResource(R.drawable.virgo);
            textViewAbout.setText(getString(R.string.virgoInfo));
        }
        else if (sign.equals("libra")){
            imageViewSign.setImageResource(R.drawable.libra);
            textViewAbout.setText(getString(R.string.libraInfo));
        }
        else if (sign.equals("scorpio")){
            imageViewSign.setImageResource(R.drawable.scorpio);
            textViewAbout.setText(getString(R.string.scorpioInfo));
        }
        else if (sign.equals("sagitarius")){
            imageViewSign.setImageResource(R.drawable.sagitarius);
            textViewAbout.setText(getString(R.string.sagitariusInfo));
        }
        else if (sign.equals("capricorn")){
            imageViewSign.setImageResource(R.drawable.capricorn);
            textViewAbout.setText(getString(R.string.capricornInfo));
        }

        // Back to MainActivity
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
    }
}
