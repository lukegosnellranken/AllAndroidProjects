package com.gmail.gosnellwebdesign.zodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Program constants
    public final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    public final int MAXMONTH = 12;
    public final int MINMONTH = 1;
    public final int MAXDAYTHIRTYONE = 31;
    public final int MAXDAYTWENTYNINE = 29;
    public final int MAXDAYTWENTYEIGHT = 28;
    public final int MAXDAYTHIRTY = 30;
    public final int MINDAY = 1;
    public final int MAXYEAR = currentYear;
    public final int MINYEAR = currentYear - 130;
    public final String NOINPUT = "You must enter a month, a day, and a year.";
    public final String INVALIDINPUT = "Invalid input.";

    //Program variables
    EditText editTextMonth;
    EditText editTextDay;
    EditText editTextYear;
    Button buttonZodiac;
    Button buttonClear;
    String outputStr;

    int inputtedMonth;
    int inputtedDay;
    int inputtedYear;
    String validatedMonth;
    String validatedDay;
    String validatedYear;
    boolean isDateValid = false;
    String fullInputtedDate;
    String userWeekday = "";
    String userAge;
    String sign = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMonth = findViewById(R.id.editTextMonth);
        editTextDay = findViewById(R.id.editTextDay);
        editTextYear = findViewById(R.id.editTextYear);
        buttonZodiac = findViewById(R.id.buttonZodiac);
        buttonClear = findViewById(R.id.buttonClear);

        buttonZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate and format inputted date
                //Check to see if empty
                try {
                    validateInput();
                    if (isDateValid) {
                        createVariablesForIntent();
                    }
                } catch (NumberFormatException nfe) {
                    //Build toast
                    Toast toast = Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG);

                    if (editTextMonth.getText().toString() == "") {
                        isDateValid = false;
                        editTextMonth.requestFocus();
                        toast = Toast.makeText(getApplicationContext(), NOINPUT + "Enter a month.", Toast.LENGTH_LONG);
                    } else if (editTextDay.getText().toString() == "") {
                        isDateValid = false;
                        editTextDay.requestFocus();
                        toast = Toast.makeText(getApplicationContext(), NOINPUT + "Enter a day.", Toast.LENGTH_LONG);
                    } else if (editTextYear.getText().toString() == "") {
                        isDateValid = false;
                        editTextDay.requestFocus();
                        toast = Toast.makeText(getApplicationContext(), NOINPUT + "Enter a year.", Toast.LENGTH_LONG);
                    }
                    toast.show();
                    return;
                }
            }
        });

        // CLEAR BUTTON
        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editTextMonth.setText("");
                editTextDay.setText("");
                editTextYear.setText("");
                editTextMonth.requestFocus();
            }
        });
    }

    public void validateInput() {
        //ASSIGN VARIABLES
        inputtedMonth = Integer.parseInt(editTextMonth.getText().toString());
        inputtedDay = Integer.parseInt(editTextDay.getText().toString());
        inputtedYear = Integer.parseInt(editTextYear.getText().toString());

        //VALIDATE MONTH
        if ((inputtedMonth > MAXMONTH) || (inputtedMonth < MINMONTH)) {
            isDateValid = false;
            //Build toast
            Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
            toast.show();
            editTextMonth.setText("");
            editTextMonth.requestFocus();
            return;
        }

        //VALIDATE DAY
        if ((inputtedMonth == 1) || (inputtedMonth == 3) || (inputtedMonth == 5) || (inputtedMonth == 7) || (inputtedMonth == 8) || (inputtedMonth == 10) || (inputtedMonth == 12)) {
            if ((inputtedDay < MINDAY) || (inputtedDay > MAXDAYTHIRTYONE)) {
                isDateValid = false;
                //Build toast
                Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                toast.show();
                editTextDay.setText("");
                editTextDay.requestFocus();
                return;
            }
        } else if (inputtedMonth == 2) {
            if ((inputtedDay < MINDAY) || (inputtedDay > MAXDAYTWENTYEIGHT)) {

                if(inputtedDay == MAXDAYTWENTYNINE){
                    if ((inputtedYear%4 == 0 && inputtedYear%100!=0) || inputtedYear%400 == 0){
                        // Continue validation, do nothing
                    }
                    else {
                        isDateValid = false;
                        //Build toast
                        Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                        toast.show();
                        editTextDay.setText("");
                        editTextDay.requestFocus();
                        return;
                    }
                }
            }
        } else if ((inputtedMonth == 4) || (inputtedMonth == 6) || (inputtedMonth == 9) || (inputtedMonth == 11)) {
            if ((inputtedDay < MINDAY) || (inputtedDay > MAXDAYTHIRTY)) {
                isDateValid = false;
                //Build toast
                Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
                toast.show();
                editTextDay.setText("");
                editTextDay.requestFocus();
                return;
            }
        }

        //VALIDATE YEAR
        if ((inputtedYear > MAXYEAR) || (inputtedYear < MINYEAR)) {
            isDateValid = false;
            //Build toast
            Toast toast = Toast.makeText(getApplicationContext(), INVALIDINPUT, Toast.LENGTH_LONG);
            toast.show();
            editTextYear.setText("");
            editTextYear.requestFocus();
            return;
        }

        isDateValid = true;
    }

    public void createVariablesForIntent() {
        //DATE IS VALIDATED

        //Set validated variables
        validatedMonth = editTextMonth.getText().toString();
        validatedDay = editTextDay.getText().toString();
        validatedYear = editTextYear.getText().toString();

        // convert individual inputs to correct formats
        if (validatedMonth.length() == 1) {
            validatedMonth = String.format("%02d", Integer.valueOf(validatedMonth));
        }
        if (validatedDay.length() == 1) {
            validatedDay = String.format("%02d", Integer.valueOf(validatedDay));
        }

        // convert user's inputted date to string
        fullInputtedDate = validatedMonth + "/" + validatedDay + "/" + validatedYear;

        // find which week day the user was born
        userWeekday = LocalDate.parse(fullInputtedDate, DateTimeFormatter.ofPattern("MM/dd/yyyy")).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);

        // find the age in years of the user
        LocalDate start = LocalDate.of(inputtedYear, inputtedMonth, inputtedDay);
        LocalDate end = LocalDate.now();
        userAge = String.valueOf(Math.toIntExact(ChronoUnit.YEARS.between(start, end)));

        // find the sign of the user
        if (((inputtedMonth == 1) && inputtedDay >= 20) || ((inputtedMonth == 2) && inputtedDay <= 18)) {
            sign = "aries";
        } else if (((inputtedMonth == 2) && inputtedDay >= 20) || ((inputtedMonth == 3) && inputtedDay <= 20)) {
            sign = "pisces";
        } else if (((inputtedMonth == 3) && inputtedDay >= 21) || ((inputtedMonth == 4) && inputtedDay <= 19)) {
            sign = "aries";
        } else if (((inputtedMonth == 4) && inputtedDay >= 20) || ((inputtedMonth == 5) && inputtedDay <= 20)) {
            sign = "taurus";
        } else if (((inputtedMonth == 5) && inputtedDay >= 21) || ((inputtedMonth == 6) && inputtedDay <= 20)) {
            sign = "gemini";
        } else if (((inputtedMonth == 6) && inputtedDay >= 21) || ((inputtedMonth == 7) && inputtedDay <= 22)) {
            sign = "cancer";
        } else if (((inputtedMonth == 7) && inputtedDay >= 23) || ((inputtedMonth == 8) && inputtedDay <= 22)) {
            sign = "leo";
        } else if (((inputtedMonth == 8) && inputtedDay >= 23) || ((inputtedMonth == 9) && inputtedDay <= 22)) {
            sign = "virgo";
        } else if (((inputtedMonth == 9) && inputtedDay >= 23) || ((inputtedMonth == 10) && inputtedDay <= 22)) {
            sign = "libra";
        } else if (((inputtedMonth == 10) && inputtedDay >= 23) || ((inputtedMonth == 11) && inputtedDay <= 21)) {
            sign = "scorpio";
        } else if (((inputtedMonth == 11) && inputtedDay >= 22) || ((inputtedMonth == 12) && inputtedDay <= 21)) {
            sign = "sagitarius";
        } else if (((inputtedMonth == 12) && inputtedDay >= 22) || ((inputtedMonth == 1) && inputtedDay <= 19)) {
            sign = "capricorn";
        }

        //Create Toast
        Toast toast = Toast.makeText(getApplicationContext(),
                                        "Birth Date: " + fullInputtedDate +
                                            "\nBirthday: " + userWeekday +
                                            "\nAge: " + userAge +
                                            "\nSign: " + sign,
                                        Toast.LENGTH_LONG);
        toast.show();

        //Create intent
        Intent intent = new Intent(getApplicationContext(), ZodiacScreenActivity.class);
        intent.putExtra("fullInputtedDate", fullInputtedDate);
        intent.putExtra("userWeekday", userWeekday);
        intent.putExtra("userAge", userAge);
        intent.putExtra("sign", sign);
        startActivity(intent);
    }
}
