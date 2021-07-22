package com.gmail.gosnellwebdesign.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Program constants
    public final int MAXGUESS = 100;
    public final int MINGUESS = 1;
    public final String NOGUESSINPUT = "No guess inputed.";
    public final String INVALIDINPUT = "Input must be between 1 and 100.";

    // Program variables
    EditText editEnterGuess;
    Button buttonSubmit;
    Button buttonClear;
    TextView textInvalid;
    TextView textResult;
    String outputStr;
    int numGuesses = 0;
    int guess = 0;
    int answer = (int )(Math.random() * 100 + 1);
    ArrayList<Integer> guessesList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        editEnterGuess = (EditText) findViewById(R.id.editTextEnterGuess);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        textInvalid = findViewById(R.id.textInvalid);
        textResult = findViewById(R.id.textResult);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Try to parse an integer from editEnterGuess and validate input
                try{
                    guess = Integer.parseInt(editEnterGuess.getText().toString());
                    while ((guess < MINGUESS) || guess > MAXGUESS){
                        // Build toast for out of range input
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();

                        // Reset variables and widgets
                        textInvalid.setText(INVALIDINPUT);
                        editEnterGuess.setText("");
                        editEnterGuess.requestFocus();
                        guess = 0;
                        return;
                    }
                }
                catch (NumberFormatException nfe) {
                    // Build toast for invalid input
                    Toast toast = Toast.makeText(getApplicationContext(), NOGUESSINPUT, Toast.LENGTH_LONG);
                    toast.show();

                    textInvalid.setText(NOGUESSINPUT);
                    return;
                }


                //If this point is reached, guess was inputted and valid.


                // Show message if input has already been guessed, otherwise increment number of guesses
                if(guessesList.contains(guess)){
                    outputStr = guess + " has already been guessed.";
                    textResult.setText("");
                    textInvalid.setText(outputStr);
                } else {
                    numGuesses++;
                    guessesList.add((int) guess);
                    textInvalid.setText("");

                    // If guess is correct, output text for user
                    if (guess == answer){
                        outputStr = "Congratulations! \nYou guessed the correct number (" + answer + ")\nin " + numGuesses + " guesses!";
                        textResult.setText(outputStr);
                    }
                    // If guess is less than answer, output text for user
                    else if (guess < answer){
                        outputStr = "Your guess (" + guess + ") is too low";
                        textResult.setText(outputStr);
                    }
                    // If guess is greater than answer, output text for user
                    else if (guess > answer) {
                        outputStr = "Your guess (" + guess + ") is too high";
                        textResult.setText(outputStr);
                    }
                }
            }
        });

        // Clear widgets and variables
        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                editEnterGuess.setText("");
                textResult.setText("");
                textInvalid.setText("");
                editEnterGuess.requestFocus();
            }
        });
    }
}