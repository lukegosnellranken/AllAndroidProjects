package com.gmail.gosnellwebdesign.arrayoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArrayOperationsTotalsActivity extends AppCompatActivity {

    //Program variables
    TextView textViewSumNumber;
    TextView textViewAvgNumber;
    TextView textViewLargestNumber;
    TextView textViewSmallestNumber;
    TextView textViewRangeNumber;
    Button buttonBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_operations_totals);

        textViewSumNumber = findViewById(R.id.textViewSumNumber);
        textViewAvgNumber = findViewById(R.id.textViewAvgNumber);
        textViewLargestNumber = findViewById(R.id.textViewLargestNumber);
        textViewSmallestNumber = findViewById(R.id.textViewSmallestNumber);
        textViewRangeNumber = findViewById(R.id.textViewRangeNumber);
        buttonBackToMain = findViewById(R.id.buttonBackToMain);

        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        String sum = extras.getString("sum");
        String avg = extras.getString("avg");
        String largest = extras.getString("largest");
        String smallest = extras.getString("smallest");
        String range = extras.getString("range");

        textViewSumNumber.setText(sum);
        textViewAvgNumber.setText(avg);
        textViewLargestNumber.setText(largest);
        textViewSmallestNumber.setText(smallest);
        textViewRangeNumber.setText(range);

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
