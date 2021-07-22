package com.gmail.gosnellwebdesign.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Program Constants
    final int MINHEIGHT = 12;
    final int MAXHEIGHT = 96;
    final int MINWEIGHT = 1;
    final int MAXWEIGHT = 777;
    final String OORHEIGHT = "Height Inputted Out of Range. \nHeight Must Be Between " + MINHEIGHT + " and " + MAXHEIGHT + ".";
    final String OORWEIGHT = "Weight Inputted Out of Range. \nWeight Must Be Between " + MINWEIGHT + " and " + MAXWEIGHT + ".";

    final double MINOPTIMAL = 18.5;
    final double MINOVER = 25;
    final double MINOBESE = 30;

    // Program Widget Variables
    EditText textHeight;
    EditText textWeight;
    Button buttonCalculate;
    Button buttonClear;
    Button buttonINDSTATS;
    Button buttonGRPSTATS;
    DecimalFormat bmiFormat = new DecimalFormat("##0.00");

    // Program Non-Widget Variables
    int totalUnderweight = 0;
    int getTotalOptimalWeight = 0;
    int totalOverweight = 0;
    int totalObese = 0;
    int height = 0;
    int weight = 0;
    double bmi = 0.0;
    String bmiStatus = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variables to view elements
        textHeight = findViewById(R.id.textHeight);
        textWeight = findViewById(R.id.textWeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear = findViewById(R.id.buttonClear);
        buttonINDSTATS = findViewById(R.id.buttonINDSTATS);
        buttonGRPSTATS = findViewById(R.id.buttonGRPSTATS);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean keepGoing = true;

                if (keepGoing){
                    keepGoing = validateHeight();
                }
                if (keepGoing){
                    keepGoing = validateWeight();
                }
                if  (keepGoing){
                    bmi = calculateBMI();
                    bmiStatus = calculateBMIStatus();
                    showIDVStats();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                clearAll();
            }
        });

        buttonINDSTATS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                showIDVStats();
            }
        });

        // Unutilized "Group Stats" button
        buttonGRPSTATS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //showGRPStats();
            }
        });
    }

    private boolean validateHeight(){
        try{
            // Read value from editTextHeight
            height = Integer.parseInt(textHeight.getText().toString());

            // Validate range of inputted height
            while ((height < MINHEIGHT) || (height > MAXHEIGHT)){
                height = 0;
                textHeight.setText("");
                textHeight.requestFocus();
                throw new NumberFormatException();
            }

            return true;
        }
        catch (NumberFormatException nfe){
            // Show toast for invalid input
            Toast toast = Toast.makeText(getApplicationContext(), OORHEIGHT, Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
    }

    private boolean validateWeight(){
        try{
            // Read value from editTextHeight
            weight = Integer.parseInt(textWeight.getText().toString());

            // Validate range of  inputted weight
            while ((weight < MINWEIGHT) || (height > MAXWEIGHT)){
                weight = 0;
                textWeight.setText("");
                textWeight.requestFocus();
                throw new NumberFormatException();
            }

            return true;
        }
        catch (NumberFormatException nfe){
            // Show toast for invalid input
            Toast toast = Toast.makeText(getApplicationContext(), OORWEIGHT, Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
    }

    // Calculate BMI
    private double calculateBMI(){
        return 703 * weight / (Math.pow(height, 2));
    }

    private String calculateBMIStatus(){
        String s = "";

        // Find BMI status and set to s
        if (bmi < MINOPTIMAL) {
            ++totalUnderweight;
            s = "Underweight";
        }
        else if ((bmi >= MINOPTIMAL) && (bmi < MINOVER)){
            ++getTotalOptimalWeight;
            s = "Optimal Weight";
        }
        else if ((bmi >= MINOVER) && (bmi < MINOBESE)){
            ++totalOverweight;
            s = "Overweight";
        }
        else {
            ++totalObese;
            s = "Obese";
        }

        return s;
    }

    // Clear all input from text boxes
    private void clearAll(){
        textHeight.setText("");
        textWeight.setText("");
        textHeight.requestFocus();
    }

    // Show the stats of the most recently calculated individual
    private void showIDVStats(){
        String indStr = "Inputted Height: " + height;
        indStr += "\nInputted Weight: " + weight;
        indStr += "\nCalculated bmi: " + bmiFormat.format(bmi);
        indStr += "\nYour bmi Status: " + bmiStatus;

        Toast toast = Toast.makeText(getApplicationContext(), indStr, Toast.LENGTH_LONG);
        toast.show();
    }

    /*private void showGRPStats(){
        String groupStr = "Total Number of Underweight Persons: " + totalUnderweight;
        groupStr += "\nTotal Number of Optimal weight Persons: " + getTotalOptimalWeight;
        groupStr += "\nTotal Number of Overweight Persons: " + totalOverweight;
        groupStr += "\nTotal Number of Obese Persons: " + totalObese;

        Toast toast = Toast.makeText(getApplicationContext(), groupStr, Toast.LENGTH_LONG);
        toast.show();
    }*/
}
