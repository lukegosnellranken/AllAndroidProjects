package com.gmail.gosnellwebdesign.original;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondaryActivity extends AppCompatActivity {
    TextView  title;
    TextView  description;
    ImageView mainImageView;
    Button buttonReturn;
    String    data1;
    String    data2;
    int       myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        title		    =	findViewById(R.id.title);
        description 	=	findViewById(R.id.artist);
        mainImageView	=	findViewById(R.id.mainImageView);
        buttonReturn    =   findViewById(R.id.buttonReturn);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getData();
        setData();
    }

    private void getData() {
        if ((getIntent().hasExtra("data1"))  &&
                (getIntent().hasExtra("data2"))  &&
                (getIntent().hasExtra("myImage")))
        {
            data1   = getIntent().getStringExtra("data1");
            data2   = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }
        else
        {
            Toast.makeText(this, "Error in data", Toast.LENGTH_LONG).show();
        }
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}
