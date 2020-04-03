package com.gmail.gosnellwebdesign.original;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Arrays;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvOriginal;

    String[] s1;
    String[] s2;
    int[] images = {R.drawable.af, R.drawable.bgttfd,
            R.drawable.ctte, R.drawable.fwano,
            R.drawable.hh, R.drawable.oao,
            R.drawable.ps, R.drawable.rs,
            R.drawable.sc, R.drawable.somm,
            R.drawable.stgstv, R.drawable.tcd,
            R.drawable.wwdooh
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvOriginal = findViewById(R.id.rvOriginal);

        s1 = getResources().getStringArray(R.array.album_titles);
        s2 = getResources().getStringArray(R.array.album_artists);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        rvOriginal.setAdapter(myAdapter);
        rvOriginal.setLayoutManager(new LinearLayoutManager(this));
    }
}