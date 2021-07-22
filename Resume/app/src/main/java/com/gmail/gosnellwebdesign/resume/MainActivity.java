package com.gmail.gosnellwebdesign.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import  android.content.Spanned;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Program Variables
    Button buttonEducation;
    Button buttonWorkExperience;
    Button buttonCallMe;
    Button buttonEmailMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        buttonEducation = findViewById(R.id.buttonEducation);
        buttonWorkExperience = findViewById(R.id.buttonWorkExperience);
        buttonEmailMe = findViewById(R.id.buttonEmailMe);
        buttonCallMe = findViewById(R.id.buttonCallMe);

        // Open ActivityEducation
        buttonEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ActivityEducation.class);
                startActivity(intent);
            }
        });

        // Open ActivityWorkExperience
        buttonWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ActivityWorkExperience.class);
                startActivity(intent);
            }
        });


        // Open phone
        buttonCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Uri phoneNumber = Uri.parse("tel: 3143690184");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                startActivity(intent);
            }
        });

        // Open email
        buttonEmailMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"gosnellwebdesign.org"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Resume");
                startActivity(intent);
            }
        });
    }
}
