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

        textViewScan = findViewById(R.id.textViewScan);
        textViewEnterArchive = findViewById(R.id.textViewEnterArchive);
        textViewVisitSite = findViewById(R.id.textViewVisitSite);

        textViewScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
            }
        });

        textViewEnterArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ArchiveActivity.class));
            }
        });

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
