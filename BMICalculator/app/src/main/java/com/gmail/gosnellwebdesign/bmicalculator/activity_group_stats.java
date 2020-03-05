package com.gmail.gosnellwebdesign.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_group_stats extends AppCompatActivity {

    TextView textViewResults;

    Integer totalUnderweight;
    Integer totalOptimalweight;
    Integer totalOverweight;
    Integer totalObese;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_stats);
        textViewResults = findViewById(R.id.textViewResults);

        //Get the intent of the target activity
        Intent intent = getIntent();

        //Get the attached bundle from the intent
        Bundle extras = intent.getExtras();

        //Extract the stored data from the bundle
        if (extras != null){
            if (extras.containsKey("totalUnderweight")){
                totalUnderweight = extras.getInt("totalUnderweight", 0);
            }
            if (extras.containsKey("totalOptimalweight")){
                totalOptimalweight = extras.getInt("totalOptimalweight", 0);
            }
            if (extras.containsKey("totalOverweight")){
                totalOverweight = extras.getInt("totalOverweight", 0);
            }
            if (extras.containsKey("totalObese")) {
                totalObese = extras.getInt("totalObese", 0);
            }

            result = "\n\tTotal Underweight: " + totalUnderweight + "\n";
            result += "\n\tTotal Optimal Weight: " + totalOptimalweight + "\n";
            result += "\n\tTotal Overweight: " + totalOverweight + "\n";
            result += "\n\tTotal Obese: " + totalObese + "\n\n";

            textViewResults.setText(result);
        }

        //Button Code removed
    }

}
