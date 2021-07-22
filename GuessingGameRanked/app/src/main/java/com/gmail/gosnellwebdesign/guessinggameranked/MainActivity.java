package com.gmail.gosnellwebdesign.guessinggameranked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    EditText editTextGuess;
    Button buttonSubmit;
    Button buttonClear;
    Button buttonRank;
    Button buttonTotals;
    TextView textViewInvalid;
    TextView textViewResponse;
    String outputStr;

    int numGuesses = 0;
    int numExperts = 0;
    int numSemipros = 0;
    int numNovices = 0;
    int guess = 0;
    int answer = (int )(Math.random() * 100 + 1);
    String rank = "";
    ArrayList<Integer> guessesList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        editTextGuess = findViewById(R.id.editTextGuess);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonClear = findViewById(R.id.buttonClear);
        buttonRank = findViewById(R.id.buttonRank);
        buttonTotals = findViewById(R.id.buttonTotals);
        textViewInvalid = findViewById(R.id.textViewInvalid);
        textViewResponse = findViewById(R.id.textViewResponse);

        // Disable the Rank button
        buttonRank.setEnabled(false);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    // Try to parse an integer from editEnterGuess and validate input
                    guess = Integer.parseInt(editTextGuess.getText().toString());
                    while ((guess < MINGUESS) || guess > MAXGUESS){
                        // Build toast for out of range input
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();

                        // Reset variables and widgets
                        textViewInvalid.setText(INVALIDINPUT);
                        editTextGuess.setText("");
                        editTextGuess.requestFocus();
                        guess = 0;
                        return;
                    }
                }
                catch (NumberFormatException nfe) {
                    // Build toast for invalid input
                    Toast toast = Toast.makeText(getApplicationContext(), NOGUESSINPUT, Toast.LENGTH_LONG);
                    toast.show();

                    textViewInvalid.setText(NOGUESSINPUT);
                    return;
                }


                //If this point is reached, guess was inputted and valid.

                // Show message if input has already been guessed, otherwise increment number of guesses
                if(guessesList.contains(guess)){
                    outputStr = guess + " has already been guessed.";
                    textViewResponse.setText("");
                    textViewInvalid.setText(outputStr);
                } else {
                    numGuesses++;
                    guessesList.add((int) guess);
                    textViewInvalid.setText("");

                    // If guess is correct, output text for user
                    if (guess == answer){
                        outputStr = "Congratulations! \nYou guessed the correct number (" + answer + ")\nin " + numGuesses + " guesses!";
                        textViewResponse.setText(outputStr);

                        // Assign rank to user depending on total number of guesses and increment number of times ranked in position
                        if (numGuesses <= 5){
                            rank = "Expert";
                            numExperts++;
                        }
                        else if (numGuesses > 5 && numGuesses <= 10){
                            rank = "Semi-Pro";
                            numSemipros++;
                        }
                        else {
                            rank = "Novice";
                            numNovices++;
                        }

                        // Show user their rank via toast
                        Toast toast = Toast.makeText(getApplicationContext(), "Your rank is: " + rank, Toast.LENGTH_LONG);
                        toast.show();

                        buttonRank.setEnabled(true);

                        resetValues();
                    }
                    // If guess is less than answer, output text for user
                    else if (guess < answer){
                        outputStr = "Your guess (" + guess + ") is too low";
                        textViewResponse.setText(outputStr);
                        numGuesses++;
                    }
                    // If guess is greater than answer, output text for user
                    else if (guess > answer) {
                        outputStr = "Your guess (" + guess + ") is too high";
                        textViewResponse.setText(outputStr);
                        numGuesses++;
                    }
                }
            }
        });

        // Reset widgets and variables
        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                editTextGuess.setText("");
                textViewResponse.setText("");
                textViewInvalid.setText("");
                editTextGuess.requestFocus();
            }
        });

        // Send intent to RankActivity
        buttonRank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), RankActivity.class);
                intent.putExtra("rank", rank);
                startActivity(intent);
            }
        });

        // Send totals to TotalActivity
        buttonTotals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), TotalsActivity.class);
                intent.putExtra("numNovices", numNovices);
                intent.putExtra("numSemipros", numSemipros);
                intent.putExtra("numExperts", numExperts);
                startActivity(intent);
            }
        });

    }

    // Reset variables and generate new random number
    public void resetValues(){
        numGuesses = 0;
        guessesList.clear();
        answer = (int )(Math.random() * 100 + 1);
    }
}
