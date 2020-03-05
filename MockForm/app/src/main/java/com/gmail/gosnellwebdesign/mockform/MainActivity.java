package com.gmail.gosnellwebdesign.mockform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Program constants
    final String zipcodeFormat = "^[0-9]{5}(?:-[0-9]{4})?$";
    final String NIP = "NO INPUT PROVIDED";
    final String NIS = "NO ITEM SELECTED";
    final String IF = "INVALID FORMAT";

    //Program variables
    EditText editTextName;
    EditText editTextAddress;
    EditText editTextCity;
    EditText editTextZipcode;
    ImageView imageViewConfirm;
    Spinner spinnerState;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    RadioGroup radioGroupShift;
    CheckBox checkBoxMorning;
    CheckBox checkBoxAfternoon;
    CheckBox checkBoxEvening;
    Switch switchSettings;

    String name;
    String address;
    String city;
    String state;
    String zipcode;
    String gender;
    String shift;
    String settings;
    String outputStr;
    String shiftString = "";
    Boolean allValidated = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextCity = findViewById(R.id.editTextCity);
        editTextZipcode = findViewById(R.id.editTextZipcode);
        spinnerState = findViewById(R.id.spinnerState);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioGroupShift = findViewById(R.id.radioGroupShift);
        checkBoxMorning = findViewById(R.id.checkBoxMorning);
        checkBoxAfternoon = findViewById(R.id.checkBoxAfternoon);
        checkBoxEvening = findViewById(R.id.checkBoxEvening);
        switchSettings = findViewById(R.id.switchSettings);
        imageViewConfirm = findViewById(R.id.imageViewConfirm);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerState);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.states, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        imageViewConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset shiftString
                shiftString = "";

                validateAll();
                if (switchSettings.isChecked()){
                    settings = "On";
                } else {
                    settings = "Off";
                }
                if (allValidated){
                    outputStr = "Name: " + name;
                    outputStr += "\nAddress: " + address;
                    outputStr += "\nState: " + state;
                    outputStr += "\nCity: " + city;
                    outputStr += "\nZipcode: " + zipcode;
                    outputStr += "\nGender: " + gender;
                    outputStr += "\nShift: " + shiftString;
                    outputStr += "\nSettings: " + settings;


                    Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

    public void validateAll(){
        name = editTextName.getText().toString();
        address = editTextAddress.getText().toString();
        city = editTextCity.getText().toString();
        zipcode = editTextZipcode.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR NAME", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }
        if (TextUtils.isEmpty(address)) {
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR ADDRESS", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }
        if (TextUtils.isEmpty(city)) {
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR CITY", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }
        if (TextUtils.isEmpty(zipcode)){
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR ZIPCODE", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }
        //validate zipcode format too


        //Validate gender
        if (radioButtonMale.isChecked()){
            gender = "Male";
        }
        else if (radioButtonFemale.isChecked()){
            gender = "Female";
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR GENDER", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }

        //Validate shift
        if (checkBoxMorning.isChecked()){
            shiftString += "Morning";
        }
        if (checkBoxAfternoon.isChecked() && checkBoxMorning.isChecked()){
            shiftString += ", Afternoon";
        }
        else if (checkBoxAfternoon.isChecked()){
            shiftString += "Afternoon";
        }
        if (checkBoxEvening.isChecked() && checkBoxAfternoon.isChecked() && checkBoxMorning.isChecked()){
            shiftString += ", Evening";
        }
        else if (checkBoxEvening.isChecked() && checkBoxAfternoon.isChecked()){
            shiftString += ", Evening";
        }
        else if (checkBoxEvening.isChecked() && checkBoxMorning.isChecked()){
            shiftString += ", Evening";
        }
        else if (checkBoxEvening.isChecked()){
            shiftString += "Evening";
        }

        if (TextUtils.isEmpty(shiftString)){
            Toast toast = Toast.makeText(getApplicationContext(), NIP + " FOR SHIFT", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }


        /*if (radioGroupGender.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast toast = Toast.makeText(getApplicationContext(), NIS + " FOR GENDER", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }*/
        /*else if (radioGroupShift.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast toast = Toast.makeText(getApplicationContext(), NIS + " FOR SHIFT", Toast.LENGTH_LONG);
            toast.show();
            allValidated = false;
            return;
        }*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        state = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Build toast
        outputStr = NIP + " FOR STATE";
        Toast toast = Toast.makeText(getApplicationContext(), outputStr, Toast.LENGTH_LONG);
        toast.show();
    }
}
