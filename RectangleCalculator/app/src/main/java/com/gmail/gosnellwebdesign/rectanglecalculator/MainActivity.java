package com.gmail.gosnellwebdesign.rectanglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Program Constants
    public final double MINWIDTH = 0.5;
    public final double MAXWIDTH = 9999;
    public final double MINHEIGHT = 0.5;
    public final double MAXHEIGHT = 9999;
    public final String INVALIDINPUT = "Input for both fields must be between " + MINWIDTH + " and " + MAXWIDTH;
    public final String NOINPUT = "Both fields must be inputted";
    public final DecimalFormat rectFormat = new DecimalFormat("##0.00");

    // Program variables
    EditText editTextWidth;
    EditText editTextHeight;
    TextView textViewAreaValue;
    TextView textViewPerimeterValue;
    Button buttonCalculate;
    Button buttonClear;
    String outputStr;


    double width = 0;
    double height = 0;
    double area = 0;
    double perimeter = 0;
    boolean isValid = false;
    boolean isNotEmpty = false;

    String areaString = "";
    String perimeterString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        editTextWidth = (EditText) findViewById(R.id.editTextRectWidth);
        editTextHeight = (EditText) findViewById(R.id.editTextRectHeight);
        textViewAreaValue = (TextView) findViewById(R.id.textViewAreaValue);
        textViewPerimeterValue = (TextView) findViewById(R.id.textViewPerimeterValue);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonClear = (Button) findViewById(R.id.buttonClear);


        // CALCULATE button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               isNotEmpty = checkIfEmpty();

               if (isNotEmpty){
                   // String is not empty
                   isValid = checkIfValid();

                   if (isValid){
                       // String is valid
                       getAreaAndPerimeter();
                   }
                   else{
                       // String is not valid
                       width = 0;
                       height = 0;
                       editTextWidth.setText("");
                       editTextHeight.setText("");
                       editTextWidth.requestFocus();
                       Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                       toast.show();
                   }
               }
               else {
                   // String is empty
                   width = 0;
                   height = 0;
                   editTextWidth.setText("");
                   editTextHeight.setText("");
                   editTextWidth.requestFocus();

                   // Build toast for no input
                   Toast toast = Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG);
                   toast.show();
               }
            }

            public boolean checkIfEmpty() {
                if (editTextWidth.getText().toString().isEmpty()) {

                    return false;
                }
                else if (editTextHeight.getText().toString().isEmpty()) {

                    return false;
                }

                return true;
            }

            public boolean checkIfValid(){
                width = Double.parseDouble(editTextWidth.getText().toString());
                height = Double.valueOf(editTextHeight.getText().toString());

                if ((width < MINWIDTH) || (width > MAXWIDTH)){

                    return false;
                }
                else if ((height < MINHEIGHT) || (height > MAXHEIGHT)){

                    return false;
                }

                return true;
            }

            private void getAreaAndPerimeter() {
                // Calculate area and perimeter
                area = width * height;
                perimeter = 2 * (width + height);

                areaString = rectFormat.format(area);
                perimeterString = rectFormat.format(perimeter);

                // Output area and perimeter
                textViewAreaValue.setText(areaString);
                textViewPerimeterValue.setText(perimeterString);

                // Build toast with rectangle area and perimeter
                outputStr = "Area: " + areaString;
                outputStr += "\nPerimeter: " + perimeterString;
                Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
                toast.show();
            }
        });


        // CLEAR button
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                width = 0;
                height = 0;
                editTextWidth.setText("");
                editTextHeight.setText("");
                textViewAreaValue.setText("");
                textViewPerimeterValue.setText("");
                editTextWidth.requestFocus();
            }
        });
    }
}
