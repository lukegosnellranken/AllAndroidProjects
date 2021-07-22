package com.gmail.gosnellwebdesign.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_individual_stats extends AppCompatActivity {
    TextView textViewResults;

    Integer height;
    Integer weight;
    String bmiStr;
    String bmiStatus;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_stats);
        textViewResults = findViewById(R.id.textViewResults);

        // Get the intent of the target activity
        Intent intent = getIntent();

        // Get the attached bundle from the intent
        Bundle extras = intent.getExtras();

        // Extract the stored data from the bundle
        if (extras != null){
            if (extras.containsKey("height")){
                height = extras.getInt("height", 0);
            }
            if (extras.containsKey("weight")){
                weight = extras.getInt("weight", 0);
            }
            if (extras.containsKey("bmiStr")){
                bmiStr = extras.getString("bmiStr", "");
            }
            if (extras.containsKey("bmiStatus")){
                bmiStatus = extras.getString("bmiStatus", "");
            }

            result = "\n\tHeight: " + height + "\n\n";
            result += "\tWeight: " + weight + "\n\n";
            result += "\tBMI: " + bmiStr + "\n\n";
            result += "\tStatus: " + bmiStatus + "\n\n";

            textViewResults.setText(result);
        }

        //Button Code removed
    }
}
