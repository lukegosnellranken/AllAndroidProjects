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

    //Program Widget Variables
    Button buttonEducation;
    Button buttonWorkExperience;
    Button buttonCallMe;
    Button buttonEmailMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEducation = findViewById(R.id.buttonEducation);
        buttonWorkExperience = findViewById(R.id.buttonWorkExperience);
        buttonEmailMe = findViewById(R.id.buttonEmailMe);
        buttonCallMe = findViewById(R.id.buttonCallMe);

        buttonEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ActivityEducation.class);
                startActivity(intent);
            }
        });

        buttonWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ActivityWorkExperience.class);
                startActivity(intent);
            }
        });


        buttonCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Uri phoneNumber = Uri.parse("tel: 3143690184");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                startActivity(intent);
            }
        });

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
