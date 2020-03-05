package com.gmail.gosnellwebdesign.fortuneteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Program constants
    final String[] fortunes = {
            "A friend asks only for your time not your money",
            "If you refuse to accept anything but the best, you very often get it",
            "Hard work pays off in the future, laziness pays off now",
            "Change can hurt, but it leads a path to something better",
            "You learn from your mistakes... You will learn a lot today",
            "A dream you have will come true",
            "You will become great if you believe in yourself",
            "You already know the answer to the questions lingering inside your head",
            "You can make your own happiness",
            "The greatest risk is not taking one",
            "You are very talented in many ways",
            "A stranger, is a friend you have not spoken to yet",
    };

    //Program variables
    Button buttonReveal;

    int randomFortuneNumber = 0;
    String randomFortune = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReveal = findViewById(R.id.buttonReveal);


        buttonReveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomFortuneNumber = (int )(Math.random() * 12 + 1);

                for(int i=0; i<fortunes.length; i++){
                    if (i == randomFortuneNumber){
                        randomFortune=fortunes[i];
                    }
                }

                Intent intent = new Intent(getApplicationContext(), OpenCookieActivity.class);
                intent.putExtra("randomFortune", randomFortune);
                startActivity(intent);
            }
        });
    }
}
