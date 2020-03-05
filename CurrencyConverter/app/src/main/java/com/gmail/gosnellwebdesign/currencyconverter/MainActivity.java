package com.gmail.gosnellwebdesign.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //String constants
    final String NO = "NO ";
    final String NEG = "NEGATIVE ";
    final String IP = "INPUT PROVIDED FOR AMOUNT TO CONVERT";
    final String NC = "NO CONVERTING RATE TO SELF RATE";

    //Currency symbols
    final String DOLLAR = "\u0024";
    final String EURO = "\u20ac";
    final String POUND = "\u00a3";
    final String FRANC = "\u20A3";
    final String YEN = "\u00A5";

    //Conversion constants
    //USD TO
    final double USD_TO_EEURO = 0.92;
    final double USD_TO_BPOUND = 0.77;
    final double USD_TO_SFRANC = 0.98;
    final double USD_TO_AUSTD = 1.49;
    final double USD_TO_CANAD = 1.33;
    final double USD_TO_NEWZD = 1.55;
    final double USD_TO_JYEN = 109.79;

    //EURO
    final double EEURO_TO_USD = 1.09;
    final double EEURO_TO_BPOUND = 0.84;
    final double EEURO_TO_SFRANC = 1.06;
    final double EEURO_TO_AUSTD = 1.66;
    final double EEURO_TO_CANAD = 1.45;
    final double EEURO_TO_NEWZD = 1.73;
    final double EEURO_TO_JYEN = 120.22;

    //POUND
    final double BPOUND_TO_USD = 1.29;
    final double BPOUND_TO_EEURO = 1.19;
    final double BPOUND_TO_SFRANC = 1.26;
    final double BPOUND_TO_AUSTD = 1.97;
    final double BPOUND_TO_CANAD = 1.72;
    final double BPOUND_TO_NEWZD = 2.05;
    final double BPOUND_TO_JYEN = 142.58;

    //CHF(franc)
    final double SFRANC_TO_USD = 1.02;
    final double SFRANC_TO_EEURO = 0.94;
    final double SFRANC_TO_BPOUND = 0.79;
    final double SFRANC_TO_AUSTD = 1.56;
    final double SFRANC_TO_CANAD = 1.36;
    final double SFRANC_TO_NEWZD = 1.63;
    final double SFRANC_TO_JYEN = 113.10;

    //AUD
    final double AUSTD_TO_USD = 0.66;
    final double AUSTD_TO_EEURO = 0.60;
    final double AUSTD_TO_BPOUND = 0.51;
    final double AUSTD_TO_SFRANC = 0.64;
    final double AUSTD_TO_CANAD = 0.87;
    final double AUSTD_TO_NEWZD = 1.04;
    final double AUSTD_TO_JYEN = 72.38;

    //CAN
    final double CANAD_TO_USD = 0.75;
    final double CANAD_TO_EEURO = 0.69;
    final double CANAD_TO_BPOUND = 0.58;
    final double CANAD_TO_SFRANC = 0.73;
    final double CANAD_TO_AUSTD = 1.15;
    final double CANAD_TO_NEWZD = 1.19;
    final double CANAD_TO_JYEN = 82.93;

    //NZD
    final double NEWZD_TO_USD = 0.63;
    final double NEWZD_TO_EEURO = 0.58;
    final double NEWZD_TO_BPOUND = 0.49;
    final double NEWZD_TO_SFRANC = 0.61;
    final double NEWZD_TO_AUSTD = 0.96;
    final double NEWZD_TO_CANAD = 0.84;
    final double NEWZD_TO_JYEN = 69.52;

    //YEN
    final double JYEN_TO_USD = 0.0091;
    final double JYEN_TO_EEURO = 0.0083;
    final double JYEN_TO_BPOUND = 0.0070;
    final double JYEN_TO_SFRANC = 0.0088;
    final double JYEN_TO_AUSTD = 0.014;
    final double JYEN_TO_CANAD = 0.012;
    final double JYEN_TO_NEWZD = 0.014;

    //Widgets
    EditText editTextAmount;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    Button buttonConvert;
    Toast t;

    boolean keepGoing;
    double inputtedAmount;
    double conversionRate;
    double convertedAmount;
    String convertedFrom;
    String convertTo;
    int from;
    int to;
    DecimalFormat df = new DecimalFormat("###,###,##0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References to widgets
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextAmount = findViewById(R.id.editTextAmountToConvert);
        buttonConvert = findViewById(R.id.buttonConvert);

        //Initialize variables
        keepGoing = true;
        inputtedAmount = 0.0;
        conversionRate = 0.0;
        convertedAmount = 0.0;
        from = -1;
        to = -1;
        convertedFrom = "";
        convertTo = "";

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currencies_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);


        //Set adapter to spinners
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keepGoing = checkForNoInput();
                if (keepGoing){
                    inputtedAmount = Integer.parseInt(editTextAmount.getText().toString());
                    doTheConversion();
                }
            }
        });
    }

    private boolean checkForNoInput(){
        //Check for no input
        if (editTextAmount.getText().toString().isEmpty()){
            t = Toast.makeText(getApplicationContext(), NO + IP, Toast.LENGTH_LONG);
            t.show();

            return false;
        }

        return true;
    }

    private void doTheConversion(){
        from = spinnerFrom.getSelectedItemPosition();
        to = spinnerTo.getSelectedItemPosition();

        switch (from) {
            case 0:
                convertedFrom = " US Dollars";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = USD_TO_EEURO;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = USD_TO_BPOUND;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = USD_TO_SFRANC;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = USD_TO_AUSTD;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = USD_TO_CANAD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = USD_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = USD_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;

            case 1:
                convertedFrom = " European Euros";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = EEURO_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = EEURO_TO_BPOUND;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = EEURO_TO_SFRANC;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = EEURO_TO_AUSTD;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = EEURO_TO_CANAD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = EEURO_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = EEURO_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 2:
                convertedFrom = "British Pounds";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = BPOUND_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = BPOUND_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = BPOUND_TO_SFRANC;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = BPOUND_TO_AUSTD;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = BPOUND_TO_CANAD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = BPOUND_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = BPOUND_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 3:
                convertedFrom = "Swiss Francs";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = SFRANC_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = SFRANC_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = SFRANC_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = SFRANC_TO_AUSTD;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = SFRANC_TO_CANAD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = SFRANC_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = SFRANC_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 4:
                convertedFrom = "Australian Dollars";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = AUSTD_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = AUSTD_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = AUSTD_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = AUSTD_TO_SFRANC;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = AUSTD_TO_CANAD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = AUSTD_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = AUSTD_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 5:
                convertedFrom = "Canadian Dollars";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = CANAD_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = CANAD_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = CANAD_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = CANAD_TO_SFRANC;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = CANAD_TO_AUSTD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = CANAD_TO_NEWZD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = CANAD_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 6:
                convertedFrom = "New Zealand Dollars";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = NEWZD_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = NEWZD_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = NEWZD_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = NEWZD_TO_SFRANC;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = NEWZD_TO_AUSTD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = NEWZD_TO_CANAD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = NEWZD_TO_JYEN;
                        convertTo = toType(7);
                        break;
                }
                break;
            case 7:
                convertedFrom = "Japanese Yen";
                switch (to) {
                    case 0:
                        conversionRate = 0;

                        t = Toast.makeText(getApplicationContext(), NC, Toast.LENGTH_LONG);
                        t.show();
                        break;
                    case 1:
                        conversionRate = JYEN_TO_USD;
                        convertTo = toType(1);
                        break;
                    case 2:
                        conversionRate = JYEN_TO_EEURO;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = JYEN_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                    case 4:
                        conversionRate = JYEN_TO_SFRANC;
                        convertTo = toType(4);
                        break;
                    case 5:
                        conversionRate = JYEN_TO_AUSTD;
                        convertTo = toType(5);
                        break;
                    case 6:
                        conversionRate = JYEN_TO_CANAD;
                        convertTo = toType(6);
                        break;
                    case 7:
                        conversionRate = JYEN_TO_NEWZD;
                        convertTo = toType(7);
                        break;
                }
                break;
        }
        convertedAmount = inputtedAmount * conversionRate;
        t = Toast.makeText(getApplicationContext(),
                            df.format(inputtedAmount).toString() + " " + convertedFrom + " = " +
                            df.format(convertedAmount).toString() + " " + convertTo,
                            Toast.LENGTH_LONG);
        t.show();
        }

        private String toType(int fromType) {
            String retVal = "";

            switch (fromType) {
                case 0:
                    retVal = " US Dollars";
                    break;

                case 1:
                    retVal = "European Euros";
                    break;

                case 2:
                    retVal = "British Pounds";
                    break;

                case 3:
                    retVal = "Swiss Francs";
                    break;

                case 4:
                    retVal = "Australian Dollars";
                    break;

                case 5:
                    retVal = "Canadian Dollars";
                    break;

                case 6:
                    retVal = "New Zealand Dollars";
                    break;

                case 7:
                    retVal = "Japanese Yen";
                    break;
            }

            return retVal;
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //state = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Build toast
        //outputStr = NIP + " FOR STATE";
        //Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
        //toast.show();
    }
}
