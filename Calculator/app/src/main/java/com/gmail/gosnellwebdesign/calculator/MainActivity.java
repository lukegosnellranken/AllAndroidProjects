
package com.gmail.gosnellwebdesign.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {


    //Program constants
    public final double MININPUT = 0;
    public final double MAXINPUT = 99999;
    public final String NOOPERATOR = "No operator selected.";
    public final String NOINPUT = "No number inputed.";
    public final String INVALIDINPUT = "Input for both fields must be between " + MININPUT + " and " + MAXINPUT;
    public final String DIVIDEBYZERO = "Illegal attempt to divide by 0.";
    public final DecimalFormat answerFormat = new DecimalFormat("###,###,##0.00");

    //Program variables
    Spinner spinnerOperators;
    EditText editTextFirstNumber;
    EditText editTextSecondNumber;
    Button buttonCalculate;
    Button buttonClear;
    TextView textViewAnswer;
    String outputStr;
    double firstNumber = 0;
    double secondNumber = 0;
    double answer = 0;
    String answerString = "";
    String operator = "";
    String operatorSymbol = "";
    boolean isValid = false;
    boolean isNotEmpty = false;
    boolean isNotDividedByZero = false;
    //String[] operatorSelections = {"Choose an Operator:", "+", "-", "*", "*", "/", "%"};
    //String selectedOperator = "";
    String textViewAnswerString = firstNumber + " " + operatorSymbol + " " + secondNumber + " = " + answerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstNumber = (EditText) findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = (EditText) findViewById(R.id.editTextSecondNumber);
        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        Spinner spinner = findViewById(R.id.spinnerOperators);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //CALCULATE button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isNotEmpty = checkIfEmpty();

                if (isNotEmpty){
                    //String is not empty
                    isValid = checkIfValid();

                    if (isValid){
                        //String is valid
                        isNotDividedByZero = checkDBZError();

                        if (isNotDividedByZero) {
                            calculateAnswer();
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(), DIVIDEBYZERO, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    else{
                        //String is not valid
                        clearAndSetFocus();
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else {
                    //String is empty
                    clearAndSetFocus();
                    Toast toast = Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            public boolean checkIfEmpty() {


                if (editTextFirstNumber.getText().toString().isEmpty()) {

                    return false;
                }

                if (editTextSecondNumber.getText().toString().isEmpty()) {

                    return false;
                }

                return true;
            }

            public boolean checkIfValid(){

                firstNumber = Double.parseDouble(editTextFirstNumber.getText().toString());
                secondNumber = Double.valueOf(editTextSecondNumber.getText().toString());

                if ((firstNumber < MININPUT) || (firstNumber > MAXINPUT)){

                    return false;
                }

                if ((secondNumber < MININPUT) || (secondNumber > MAXINPUT)){

                    return false;
                }

                return true;
            }

            public boolean checkDBZError(){
                if (operator == "divide" && secondNumber == 0){
                    return false;
                }

                return true;
            }

            public void calculateAnswer() {
                //Calculate the answer
                if (operator == "add"){
                    answer = firstNumber + secondNumber;
                    operatorSymbol = "+";
                }
                else if (operator == "subtract"){
                    answer = firstNumber - secondNumber;
                    operatorSymbol = "-";
                }
                else if (operator == "multiply"){
                    answer = firstNumber * secondNumber;
                    operatorSymbol = "*";
                }
                else if (operator == "divide"){
                    answer = firstNumber / secondNumber;
                    operatorSymbol = "/";
                }
                else if (operator == "modulus"){
                    answer = firstNumber % secondNumber;
                    operatorSymbol = "%";
                }

                answerString = answerFormat.format(answer);

                //Output answer
                textViewAnswerString = (firstNumber + " " + operatorSymbol + " " + secondNumber + " = " + answer);
                textViewAnswer.setText(textViewAnswerString);

                //Build toast
                outputStr = answerString;
                Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
                toast.show();
            }

            private void clearAndSetFocus(){
                firstNumber = 0;
                secondNumber = 0;
                editTextFirstNumber.setText("");
                editTextSecondNumber.setText("");
                editTextFirstNumber.requestFocus();
            }
        });

        //CLEAR button
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = 0;
                secondNumber = 0;
                answer = 0;
                answerString = "";
                operator = "";
                operatorSymbol = "";
                editTextFirstNumber.setText("");
                editTextSecondNumber.setText("");
                textViewAnswer.setText("");
                editTextFirstNumber.requestFocus();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("+")){
            operator = "add";
        }
        else if (text.equals("-")){
            operator = "subtract";
        }
        else if (text.equals("*")){
            operator = "multiply";
        }
        else if (text.equals("/")){
            operator = "divide";
        }
        else if (text.equals("%")){
            operator = "modulus";
        }
        //Toast.makeText(parent.getContext(), operator, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Build toast
        outputStr = NOOPERATOR;
        Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
        toast.show();
    }
}