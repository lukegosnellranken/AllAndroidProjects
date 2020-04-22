package com.gmail.gosnellwebdesign.veteransmuseumprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonScanCode;
    Button buttonArchives;
    Button buttonWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScanCode = findViewById(R.id.buttonScanCode);
        buttonArchives = findViewById(R.id.buttonArchives);
        buttonWebsite = findViewById(R.id.buttonWebsite);

        buttonScanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
            }
        });

        /*buttonArchives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ArchivesActivity.class));
            }
        });*/

        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://stcharlescountyveteransmuseum.org/"));
                startActivity(browserIntent);
            }
        });

    }
}
