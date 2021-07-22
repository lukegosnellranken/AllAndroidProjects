package com.gmail.gosnellwebdesign.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.Html;

public class ActivityEducation extends AppCompatActivity {

    Button buttonEducationBackToMain;
    TextView textViewEducationInfo;
    Spanned ConvertHTML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Widget references
        buttonEducationBackToMain = findViewById(R.id.buttonEducationBackToMain);
        textViewEducationInfo = findViewById(R.id.textViewEducationInfo);

        ConvertHTML = Html.fromHtml(
                "<strong><u>E D U C A T I O N</u></strong><br />\n" +
                        "<br>" +
                        "<br>" +
                        "<strong>Ranken Technical College</strong><br />\n" +
                        "<br>" +
                        "Currently attending Application Web Development program\n" +
                        "<br>" +
                        "Phi Theta Kappa Honor Society member" +
                        "<br>" +
                        "SkillsUSA member\n" +
                        "<br>" +
                        "<br>" +
                        "<strong>St. Charles Community College</strong><br />\n" +
                        "<br>" +
                        "Graduated with Associates degree (AAA)\n" +
                        "<br>" +
                        "Phi Theta Kappa Honor Society member\n" +
                        "<br>" +
                        "<br>" +
                        "<strong>Timberland High School</strong><br />\n" +
                        "<br>" +
                        "Graduated with honors and Cum Laude\n" +
                        "<br>" +
                        "Attended Lewis and Clark Career Center CIS class 2014-16\n"
        );

        // Set textView to ConvertHTML
        textViewEducationInfo.setText(ConvertHTML);

        // Back to MainActivity
        buttonEducationBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
