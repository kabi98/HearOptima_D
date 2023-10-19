package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingAidList;

public class TestResultInput extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton dataInputBtn;
    AppCompatButton myHearingAidBtn;
    ImageButton returnMenuBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input);

        dataInputBtn = findViewById(R.id.dataInput);
        dataInputBtn.setOnClickListener(this);
        returnMenuBtn = findViewById(R.id.returnMenu);
        returnMenuBtn.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.dataInput) {
            Intent intent = new Intent(getApplicationContext(), SurveyResult.class);
            startActivity(intent);
        }
    }
}
