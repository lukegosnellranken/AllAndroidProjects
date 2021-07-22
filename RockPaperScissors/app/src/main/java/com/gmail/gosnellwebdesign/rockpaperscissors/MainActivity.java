package com.gmail.gosnellwebdesign.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Program constants
    final String rock = "Rock";
    final String paper = "Paper";
    final String scissors = "Scissors";

    // Program variables
    ImageView imageViewRock;
    ImageView imageViewPaper;
    ImageView imageViewScissors;
    TextView textViewComputerChoiceDisplay;
    TextView textViewUserChoiceDisplay;
    TextView textViewWinnersIs;
    TextView textViewWinner;
    Button buttonTotals;
    String outputStr;

    int numComputerWins = 0;
    int numUserWins = 0;
    int numTies = 0;
    String computerChoice = "";
    String userChoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        imageViewRock = findViewById(R.id.imageViewRock);
        imageViewPaper = findViewById(R.id.imageViewPaper);
        imageViewScissors = findViewById(R.id.imageViewScissors);
        textViewComputerChoiceDisplay = findViewById(R.id.textViewComputerChoiceDisplay);
        textViewUserChoiceDisplay = findViewById(R.id.textViewUserChoiceDisplay);
        textViewWinnersIs = findViewById(R.id.textViewWinnerIs);
        textViewWinner = findViewById(R.id. textViewWinner);
        buttonTotals = findViewById(R.id.buttonTotals);

        // Disable the Totals button
        buttonTotals.setEnabled(false);

        // Set computer choice
        setComputerChoice();

        // Set winnerIs textView to empty until user plays
        textViewWinnersIs.setText("");

        // Setting userChoice depending on image tapped
        imageViewRock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClicked();
                userChoice = rock;
                calculateWinner();
            }
        });

        imageViewPaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClicked();
                userChoice = paper;
                calculateWinner();
            }
        });

        imageViewScissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClicked();
                userChoice = scissors;
                calculateWinner();
            }
        });

        buttonTotals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                // Intent for ActivityTotals
                Intent intent = new Intent(getApplicationContext(), ActivityTotals.class);
                intent.putExtra("numComputerWins", numComputerWins);
                intent.putExtra("numUserWins", numUserWins);
                intent.putExtra("numTies", numTies);
                startActivity(intent);
            }
        });

    }

    public void buttonClicked(){
        buttonTotals.setEnabled(true);
    }

    // Set computer choice depending on random number generated
    public void setComputerChoice(){
        int randomNumber = (int )(Math.random() * 3 + 1);

        if (randomNumber == 1){
            computerChoice = rock;
        } else if (randomNumber == 2) {
            computerChoice = paper;
        } else if (randomNumber == 3){
            computerChoice = scissors;
        }
    }

    public void calculateWinner(){
        // Set winerIs TextView
        textViewWinnersIs.setText("The winner is...");

        // Set user text
        if (userChoice == rock){
            textViewUserChoiceDisplay.setText(rock);
        }
        else if (userChoice == paper){
            textViewUserChoiceDisplay.setText(paper);
        }
        else if (userChoice == scissors){
            textViewUserChoiceDisplay.setText(scissors);
        }

        // Set computer text
        if (computerChoice == rock){
            textViewComputerChoiceDisplay.setText(rock);
        }
        else if (computerChoice == paper){
            textViewComputerChoiceDisplay.setText(paper);
        }
        else if (computerChoice == scissors){
            textViewComputerChoiceDisplay.setText(scissors);
        }

        // Calculate winner
        if ((userChoice == rock && computerChoice == scissors) || (userChoice == paper && computerChoice == rock) || (userChoice == scissors && computerChoice == paper)){
            numUserWins++;
            textViewWinner.setText("User");
        }
        else if ((userChoice == scissors && computerChoice == rock) || (userChoice == rock && computerChoice == paper) || (userChoice == paper && computerChoice == scissors)){
            numComputerWins++;
            textViewWinner.setText("Computer");
        } else {
            numTies++;
            textViewWinner.setText("Draw");
        }

        // Reset
        userChoice = "";
        setComputerChoice();
    }

}
