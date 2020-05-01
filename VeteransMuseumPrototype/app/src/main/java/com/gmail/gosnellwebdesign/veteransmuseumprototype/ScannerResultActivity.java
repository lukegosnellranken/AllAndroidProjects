package com.gmail.gosnellwebdesign.veteransmuseumprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ScannerResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_result);

        // Get QR code, process it. If (code) then (request HTTP WP content)
        // Separate if statements for each code
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String QRCode = extras.getString("QRCode");
        }

    }

    /*private void processQRCode() throws IOException {
        if (code.value){
            URL url = new URL("http://www.android.com/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                readStream(in);
            }
            finally {
                urlConnection.disconnect();
            }
        }
    }*/
}
