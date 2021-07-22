package com.gmail.gosnellwebdesign.veteransmuseumfull;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class ScannerResultActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    TextView title;
    WebView webView;
    int postID;

    final String INVALIDCODE = "Invalid Code. Please Try again!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdetails);

        // Widget references
        webView = (WebView) findViewById(R.id.postwebview);

        webView.getSettings().setJavaScriptEnabled(true);

        // Get intent from ScannerActivity
        Intent intent = getIntent();
        String codeString = intent.getStringExtra("QRCode");
        //final String id = "67";

        //Toast.makeText(ScannerResultActivity.this, codeString, Toast.LENGTH_LONG).show();

        // I generated two separate QR codes to test this feature of the app. It was a success.
        // The QR codes return the associated veteran posts
        if (codeString.equals("sturhahn")){
            // postID = 174;
            webView.loadUrl("http://stcharlescountyveteransmuseum.org/storiesarchive/cpl-roland-bo-sturhahn/");
            // to open webview inside app -- otherwise It will open url in device browser
            webView.setWebViewClient(new WebViewClient());
        }
        else if (codeString.equals("prevedel")){
            //postID = 174;
            webView.loadUrl("http://stcharlescountyveteransmuseum.org/storiesarchive/sgt-charles-f-prevedel/");
            // to open webview inside app -- otherwise It will open url in device browser
            webView.setWebViewClient(new WebViewClient());
        }
        else{
            //Build toast for invalid QR code
            Toast.makeText(ScannerResultActivity.this, INVALIDCODE, Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), ScannerActivity.class);
            startActivity(i);
        }

        //  title.setText( MainActivity.mListPost.get(position).getTitle().getRendered());
    }
}
