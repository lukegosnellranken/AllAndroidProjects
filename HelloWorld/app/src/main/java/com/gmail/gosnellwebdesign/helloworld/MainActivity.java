package com.gmail.gosnellwebdesign.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Define program constants
    String name = "";
    EditText editTextName;
    Button buttonCalculate;


    //TWO SEPARATE WAYS TO RUN THIS PROGRAM

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        /*buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString();

                //Check for blank name
                if (name.isEmpty()){
                    name = "name-shy";
                }

                Toast toast = Toast.makeText(getApplicationContext(), "Hello " + name, Toast.LENGTH_LONG);
                toast.show();
            }
        });*/
    }
        public void sayHello(View v){
            name = editTextName.getText().toString();

            //Check for blank name
            if (name.isEmpty()){
                name = "name-shy";
            }

            Toast toast = Toast.makeText(getApplicationContext(), "Hello " + name, Toast.LENGTH_LONG);
            toast.show();
        }
}
