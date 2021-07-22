package com.gmail.gosnellwebdesign.measurement;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Output;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Program Constants
    public final double MINMILESANDKILOS = 0.1;
    public final double MAXMILESANDKILOS = 9999;
    public final double MILESTOKILOMETERSRATIO = 1.6093;
    public final double KILOMETERSTOMILESRATIO = 0.6214;
    public final String NOINPUT = "No value inputted";
    public final String INVALIDINPUT = "Input must be between " + MINMILESANDKILOS + " and " + MAXMILESANDKILOS;

    // Program variables
    EditText editTextUserValue;
    TextView textViewConversionTitle;
    TextView textViewOutput;
    Button buttonMilesToKilo;
    Button buttonKiloToMiles;
    String outputStr;
    DecimalFormat conversionFormat = new DecimalFormat("##0.00");

    double userValue = 0;
    double miles = 0;
    double kilos = 0;
    boolean isNotEmpty = true;
    boolean isValid = true;

    String kilosString = "";
    String milesString = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        textViewConversionTitle = (TextView) findViewById(R.id.textViewConversionTitle);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);
        editTextUserValue = (EditText) findViewById(R.id.editTextUserValue);
        buttonMilesToKilo = (Button) findViewById(R.id.buttonMilesToKilo);
        buttonKiloToMiles = (Button) findViewById(R.id.buttonKiloToMiles);

        // MILES TO KILOMETERS button
        buttonMilesToKilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewConversionTitle.setText("Miles to Kilometers Conversion");

                isNotEmpty = checkIfEmpty();

                if (isNotEmpty){
                    // String is not empty
                    isValid = checkIfValid();

                    if (isValid){
                        // String is valid

                        getAndConvertToKilometers();
                    }
                    else{
                        // String is not valid
                        miles = 0;
                        kilos = 0;
                        editTextUserValue.setText("");
                        textViewConversionTitle.setText("");
                        editTextUserValue.requestFocus();
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else {
                    // String is empty
                    miles = 0;
                    kilos = 0;
                    editTextUserValue.setText("");
                    textViewConversionTitle.setText("");
                    editTextUserValue.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG);
                    toast.show();
                }
            }


            public boolean checkIfEmpty() {

                if (editTextUserValue.getText().toString().isEmpty()) {

                    return false;
                }

                return true;
            }

            public boolean checkIfValid(){

                miles = Double.parseDouble(editTextUserValue.getText().toString());

                if ((miles < MINMILESANDKILOS) || (miles > MAXMILESANDKILOS)){

                    return false;
                }

                return true;
            }

            private void getAndConvertToKilometers() {
                // Calculate M to K
                kilos = miles * MILESTOKILOMETERSRATIO;

                kilosString = conversionFormat.format(kilos);
                milesString = conversionFormat.format(miles);

                // Output kilos
                textViewOutput.setText(kilosString);

                // Build toast
                outputStr = "There are " + kilosString + " kilometers in " + milesString + " miles.";
                Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
                toast.show();
            }
        });


        // KILOMETERS TO MILES button
        buttonKiloToMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewConversionTitle.setText("Kilometers to Miles Conversion");

                isNotEmpty = checkIfEmpty();

                if (isNotEmpty){
                    // String is not empty
                    isValid = checkIfValid();

                    if (isValid){
                        // String is valid

                        getAndConvertToMiles();
                    }
                    else{
                        // String is not valid
                        miles = 0;
                        kilos = 0;
                        editTextUserValue.setText("");
                        textViewConversionTitle.setText("");
                        editTextUserValue.requestFocus();
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else {
                    // String is empty
                    miles = 0;
                    kilos = 0;
                    editTextUserValue.setText("");
                    textViewConversionTitle.setText("");
                    editTextUserValue.requestFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG);
                    toast.show();
                }
            }


            public boolean checkIfEmpty() {


                if (editTextUserValue.getText().toString().isEmpty()) {

                    return false;
                }

                return true;
            }

            public boolean checkIfValid(){

                kilos = Double.parseDouble(editTextUserValue.getText().toString());

                if ((kilos < MINMILESANDKILOS) || (kilos > MAXMILESANDKILOS)){

                    return false;
                }

                return true;
            }

            private void getAndConvertToMiles() {
                // Calculate K to M
                miles = kilos * KILOMETERSTOMILESRATIO;

                kilosString = conversionFormat.format(kilos);
                milesString = conversionFormat.format(miles);

                //Output miles
                textViewOutput.setText(milesString);

                //Build toast
                outputStr = "There are " + milesString + " miles in " + kilosString + " kilometers.";
                Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
                toast.show();
            }


        });

    }
}
