package com.example.hearoptima_d_01.views.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.TestResultInput.DataInputChoice;
import com.example.hearoptima_d_01.views.TestResultInput.TestResultInput;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton testResultInputBtn;
    AppCompatButton findHearingAidBtn;
    AppCompatButton infoHearingAidBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        testResultInputBtn = findViewById(R.id.testResultInput);
        testResultInputBtn.setOnClickListener(this);

        findHearingAidBtn = findViewById(R.id.findHearingAid);
        findHearingAidBtn.setOnClickListener(this);

        infoHearingAidBtn = findViewById(R.id.infoHearingAid);
        infoHearingAidBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.testResultInput){
            Intent intent = new Intent(getApplicationContext(), DataInputChoice.class);
            startActivity(intent);
        }
    }
}
