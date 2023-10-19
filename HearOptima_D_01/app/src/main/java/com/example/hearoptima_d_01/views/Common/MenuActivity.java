package com.example.hearoptima_d_01.views.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingAidList;
import com.example.hearoptima_d_01.views.TestResultInput.DataInputChoice;
import com.example.hearoptima_d_01.views.TestResultInput.SurveyStart;
import com.example.hearoptima_d_01.views.TestResultInput.TestResultInput;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton havetestResultInputBtn;
    AppCompatButton nothavetestResultInputBtn;

    AppCompatButton findHearingAidBtn;
    AppCompatButton infoHearingAidBtn;
    AppCompatButton infocochlearImplantBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        havetestResultInputBtn = findViewById(R.id.haveTestResult);
        havetestResultInputBtn.setOnClickListener(this);

        nothavetestResultInputBtn = findViewById(R.id.notHavaTestResult);
        nothavetestResultInputBtn.setOnClickListener(this);

        findHearingAidBtn = findViewById(R.id.findHearingAid);
        findHearingAidBtn.setOnClickListener(this);

        infoHearingAidBtn = findViewById(R.id.infohearingAid);
        infoHearingAidBtn.setOnClickListener(this);

        infocochlearImplantBtn = findViewById(R.id.infocochlearImplant);
        infocochlearImplantBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.haveTestResult){
            Intent intent = new Intent(getApplicationContext(), TestResultInput.class);
            startActivity(intent);
        } else if (view.getId() == R.id.notHavaTestResult) {
            Intent intent = new Intent(getApplicationContext(), SurveyStart.class);
            startActivity(intent);
        } else if (view.getId() == R.id.findHearingAid) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFindAddfilter.class);
            startActivity(intent);
//        } else if (view.getId() == R.id.infohearingAid) {
//            Intent intent = new Intent(getApplicationContext(), .class);
//            startActivity(intent);
//        } else if (view.getId() == R.id.infocochlearImplant) {
//            Intent intent = new Intent(getApplicationContext(), .class);
//            startActivity(intent);
        }
    }
}
