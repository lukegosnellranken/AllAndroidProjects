package com.gmail.gosnellwebdesign.guessinggameranked;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RankActivity extends AppCompatActivity {

    //Program variables
    Button buttonRanksBackToMain;
    ImageView imageViewRankStatus;
    TextView textViewRankStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        buttonRanksBackToMain = findViewById(R.id.buttonRanksBackToMain);
        imageViewRankStatus = findViewById(R.id.imageViewRankStatus);
        textViewRankStatus = findViewById(R.id.textViewRankStatus);

        Intent intent = getIntent();
        String rank = intent.getStringExtra("rank");

        if (rank.equals("Novice")){
            imageViewRankStatus.setImageResource(R.drawable.novice);
            textViewRankStatus.setText("Novice");

        }
        else if (rank.equals("Semi-Pro")){
            imageViewRankStatus.setImageResource(R.drawable.nice);
            textViewRankStatus.setText("Semi-Pro");
        }
        else if (rank.equals("Expert")){
            imageViewRankStatus.setImageResource(R.drawable.wow);
            textViewRankStatus.setText("Expert");
        }


        buttonRanksBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });


    }
}
