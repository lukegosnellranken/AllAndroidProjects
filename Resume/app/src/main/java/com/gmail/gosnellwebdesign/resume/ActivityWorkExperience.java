package com.gmail.gosnellwebdesign.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.Html;

public class ActivityWorkExperience extends AppCompatActivity {

    Button buttonWorkExperienceBackToMain;
    TextView textViewWorkExperienceInfo;
    Spanned ConvertHTML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience);

        buttonWorkExperienceBackToMain = findViewById(R.id.buttonWorkExperienceBackToMain);
        textViewWorkExperienceInfo = findViewById(R.id.textViewWorkExperienceInfo);

        ConvertHTML = Html.fromHtml(
    "<strong><u>W O R K  E X P E R I E N C E</u></strong><br />\n" +
            "<br>" +
            "<br>" +
            "<strong>Web Developer, Self-employed</strong><br />\n" +
            "<br>" +
            "2018(November) -2020(current)\n" +
            "<br>" +
            "I have designed and developed several websites for clients. See my personal website for examples of my work.\n\n" +
            "<br>" +
            "<br>" +
            "<strong>\nTutor, Ranken Technical College</strong><br />\n" +
            "<br>" +
            "2019(September) - 2020(current)\n" +
            "<br>" +
            "Tutoring Jeff Scott’s Application Web Development students allows me to sharpen my programming skills while helping and guiding others.\n\n" +
            "<br>" +
            "<br>" +
            "<strong>\nCode Sensei, Code Ninjas</strong><br />\n" +
            "<br>" +
            "2018(December) -2020(current)\n" +
            "<br>" +
            "I help kids learn how to code using primarily Scratch and JavaScript. I have put together many presentations and helped with several events to help advertise the business, as well as offered my input in how to improve our services.\n"
        );

        textViewWorkExperienceInfo.setText(ConvertHTML);

        buttonWorkExperienceBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
