package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;

public class DataInputChoice extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton hospitalExamBtn;
    AppCompatButton surveyStartBtn;
    ImageButton returnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input_choice);

        hospitalExamBtn = findViewById(R.id.hospitalExam);
        hospitalExamBtn.setOnClickListener(this);

        surveyStartBtn = findViewById(R.id.surveyStart);
        surveyStartBtn.setOnClickListener(this);

        returnMenu = findViewById(R.id.returnMenu);
        returnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.hospitalExam){
            Intent intent = new Intent(getApplicationContext(), TestResultInput.class);
            startActivity(intent);
        } else if (view.getId() == R.id.returnMenu) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.surveyStart) {
            Intent intent = new Intent(getApplicationContext(), SurveyStart.class);
            startActivity(intent);
        }
    }
}
