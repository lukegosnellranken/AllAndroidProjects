package com.gmail.gosnellwebdesign.veteransmuseumfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewScan;
    TextView textViewVisitSite;
    TextView textViewEnterArchive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Widget references
        textViewScan = findViewById(R.id.textViewScan);
        textViewEnterArchive = findViewById(R.id.textViewEnterArchive);
        textViewVisitSite = findViewById(R.id.textViewVisitSite);

        // Intent for QR scanner
        textViewScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
            }
        });

        // Intent for archive viewer
        textViewEnterArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ArchiveActivity.class));
            }
        });

        // Intent for stcharlescountyveteransmuseum.org
        textViewVisitSite.setOnClickListener(new View.OnClickListener() {
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
