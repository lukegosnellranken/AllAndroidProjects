package com.gmail.gosnellwebdesign.veteransmuseumfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ProgressDialog;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.Map;

public class PostActivity extends AppCompatActivity {

    TextView title;
    WebView content;
    ProgressDialog progressDialog;
    Gson gson;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    Map<String, Object> mapContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        final String id = getIntent().getExtras().getString("id");
        String errortest = "error test";

        // Widget references
        title = (TextView) findViewById(R.id.title);
        content = (WebView)findViewById(R.id.content);

        // Loading animation for posts
        progressDialog = new ProgressDialog(PostActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        // Url structure for post location
        String url = "http://www.thejavaprogrammer.com/wp-json/wp/v2/posts/"+id+"?fields=title,content";

        // Get request for post data
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            // Map post data to variables
            public void onResponse(String s) {
                gson = new Gson();
                mapPost = (Map<String, Object>) gson.fromJson(s, Map.class);
                mapTitle = (Map<String, Object>) mapPost.get("title");
                mapContent = (Map<String, Object>) mapPost.get("content");

                title.setText(mapTitle.get("rendered").toString());
                content.loadData(mapContent.get("rendered").toString(),"text/html","UTF-8");

                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // Abort post load if error occurs
                progressDialog.dismiss();
                Toast.makeText(PostActivity.this, id, Toast.LENGTH_LONG).show();
            }
        });

        // Add posts to RequestQueue to display to screen
        RequestQueue rQueue = Volley.newRequestQueue(PostActivity.this);
        rQueue.add(request);
    }
}