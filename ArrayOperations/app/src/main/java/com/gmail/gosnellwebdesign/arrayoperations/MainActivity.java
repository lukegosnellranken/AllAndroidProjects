package com.gmail.gosnellwebdesign.arrayoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    // Program variables
    TextView textViewArray;
    Button buttonSortAscending;
    Button buttonSortDescending;
    Button buttonTotals;
    Button buttonNewNumbers;

    int sum;
    double avg;
    int largest;
    int smallest;
    int range;

    ArrayList<Integer> numberArray = new ArrayList<Integer>();
    String numberArrayString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set variables to view elements
        textViewArray = findViewById(R.id.textViewArray);
        buttonSortAscending = findViewById(R.id.buttonSortAscending);
        buttonSortDescending = findViewById(R.id.buttonSortDescending);
        buttonTotals = findViewById(R.id.buttonTotals);
        buttonNewNumbers = findViewById(R.id.buttonNewNumbers);

        generateNewNumbers();

        buttonNewNumbers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                generateNewNumbers();
            }
        });

        // Create and start Totals view when user taps the "Totals" button
        buttonTotals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ArrayOperationsTotalsActivity.class);
                Bundle extras = new Bundle();
                extras.putString("sum", sum + "");
                extras.putString("avg", avg + "");
                extras.putString("largest", largest + "");
                extras.putString("smallest", smallest + "");
                extras.putString("range", range + "");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        buttonSortAscending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                textViewArray.setText("");
                numberArrayString = "";
                // Sort items in array in ascending order
                Collections.sort(numberArray);

                // Add each number in ArrayList to a string through iteration
                for(int j=0;j<25;j++){
                    numberArrayString += numberArray.get(j) + ", ";
                }

                // Add the array string to the textbox
                textViewArray.setText(numberArrayString);

            }
        });

        buttonSortDescending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                textViewArray.setText("");
                numberArrayString = "";
                // Sort items in array in descending order
                Collections.reverse(numberArray);

                // Add each number in ArrayList to a string through iteration
                for(int j=0;j<25;j++){
                    numberArrayString += numberArray.get(j) + ", ";
                }

                // Add the array string to the textbox
                textViewArray.setText(numberArrayString);
            }
        });

    }

    public void generateNewNumbers(){
        clearAndReset();

        // Create 25 random numbers and add them to numberArray through iteration
        for(int i=0;i<25;i++){
            int newNumber = (int)(Math.random() * 99 + 1);
            numberArray.add(newNumber);
        }

        // Add each number in ArrayList to a string through iteration
        for(int j=0;j<25;j++){
            numberArrayString += numberArray.get(j) + ", ";
        }

        // Display string
        textViewArray.setText(numberArrayString);

        calculateTotals();
    }

    public void calculateTotals(){
        // Through iteration, calculate sum, largest number, and smallest number
        for (int i=0; i<numberArray.size();i++){
            int currentNumber = numberArray.get(i);
            sum += currentNumber;
            if (currentNumber > largest){
                largest = currentNumber;
            }
            //Small number check. Smallest is first assigned to first array element
            if (i == 0){
                smallest = currentNumber;
            }
            if (currentNumber < smallest){
                smallest = currentNumber;
            }
        }

        //Calculate the average and range of all items in array
        avg = sum/numberArray.size();
        range = largest - smallest;
    }

    // Clear array and reset program variables
    public void clearAndReset(){
        numberArray.clear();
        numberArrayString = "";
        textViewArray.setText("");
        sum = 0;
        avg = 0;
        largest = 0;
        smallest = 0;
        range = 0;
    }
}
