package com.gmail.gosnellwebdesign.veteransmuseumfull;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


public class WPPostDetails extends AppCompatActivity {
    TextView title;
    WebView webView;
    ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdetails);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        //title = (TextView) findViewById(R.id.title);
        webView = (WebView) findViewById(R.id.postwebview);
        Intent i = getIntent();
        int position = i.getExtras().getInt("itemPosition");

        //  title.setText( MainActivity.mListPost.get(position).getTitle().getRendered());
        Log.e("WpPostDetails ", "  title is " + ArchiveActivity.mListPost.get(position).getTitle().getRendered());

        progressBar.setVisibility(View.GONE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(ArchiveActivity.mListPost.get(position).getLink());
        // to open webview inside app -- otherwise It will open url in device browser
        webView.setWebViewClient(new WebViewClient());

    }
}