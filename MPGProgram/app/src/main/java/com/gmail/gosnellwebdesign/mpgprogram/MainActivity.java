package com.gmail.gosnellwebdesign.mpgprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Program Constants
    public final int MINMILESDRIVEN = 1;
    public final int MAXMILESDRIVEN = 100;
    public final int MINGALLONSUSED = 1;
    public final int MAXGALLONSUSED = 100;
    public final String NOMILESINPUT = "NO MILES DRIVEN INPUTTED! RESETTING AND RETURNING.";
    public final String NOGALLONSINPUT = "NO GALLONS USED INPUTTED! RESETTING AND RETURNING.";

    //Program variables
    EditText editTextMiles;
    EditText editTextGallons;
    Button buttonCalculate;
    String outputStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //FIX - TURN TEXTVIEWS TO EDITTEXTS
        editTextMiles = (EditText) findViewById(R.id.editMilesDriven);
        editTextGallons = (EditText) findViewById(R.id.editGallonsUsed);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double miles = 0;
                double gallons = 0;
                double mpg = 0;

                try{
                    //Read value from first edit text
                    // //attempt to parse and put in variable miles
                    miles = Double.parseDouble(editTextMiles.getText().toString());
                    while ((miles < MINMILESDRIVEN) || miles > MAXMILESDRIVEN){
                        miles = 0;
                        editTextMiles.setText("");
                        editTextGallons.requestFocus();
                        return;
                    }
                }
                catch (NumberFormatException nfe) {
                    Toast toast = Toast.makeText(getApplicationContext(), NOMILESINPUT, Toast.LENGTH_LONG);
                    toast.show();;
                    return;
                }

                //If this point is reached, miles were inputted and valid.

                try{
                    //Read value from first edit text
                    // //attempt to parse and put in variable miles
                    gallons = Double.parseDouble(editTextGallons.getText().toString());
                    while ((gallons < MINGALLONSUSED) || miles > MAXGALLONSUSED){
                        gallons = 0;
                        editTextGallons.setText("");
                        editTextGallons.requestFocus();
                        return;
                    }
                }
                catch (NumberFormatException nfe) {
                    Toast toast = Toast.makeText(getApplicationContext(), NOGALLONSINPUT, Toast.LENGTH_LONG);
                    toast.show();;
                    return;
                }

                //If this point is reached, gallons (and miles) were inputted and valid.

                mpg = miles / gallons;

                //Build toast
                outputStr = "You drove " + String.valueOf(miles) + " miles.";
                outputStr += "\nYou used: " + String.valueOf(gallons) + "gallons";
                outputStr += "\n Your MPG: " + String.valueOf(mpg);
                Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
            }
        });
    }

    public void clearAll(View v){
        editTextMiles.setText((""));
        editTextGallons.setText("");
        editTextMiles.requestFocus();
    }
}
