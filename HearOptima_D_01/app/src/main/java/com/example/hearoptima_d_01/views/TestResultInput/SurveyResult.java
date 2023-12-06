package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingLossInfo;

public class SurveyResult extends AppCompatActivity implements View.OnClickListener {

    TextView hearingLossExpectation, resultExpectation, hearingLossInfo, hearingAidList;
    ImageView hearingLossView;
    ImageButton HomeImageBtn, HearingAidSearchImageBtn, HearingAidInfoImageBtn, MyPageImageBtn, backBtn;
    AppCompatButton MyHearingAid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_result);

        String resultMessage = getIntent().getStringExtra("RESULT_MESSAGE");

        TextView resultTextView = findViewById(R.id.hearingLossClassification);
        resultTextView.setText(resultMessage);

        HomeImageBtn = findViewById(R.id.HomeImage);
        HomeImageBtn.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        HearingAidInfoImageBtn = findViewById(R.id.HearingAidInfoImage);
        HearingAidInfoImageBtn.setOnClickListener(this);

        MyPageImageBtn = findViewById(R.id.MyPageImage);
        MyPageImageBtn.setOnClickListener(this);

        MyHearingAid = findViewById(R.id.myHearingAid);
        MyHearingAid.setOnClickListener(this);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
    }
    public void onClick(View view){
        if (view.getId() == R.id.HomeImage){
            finish();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(getApplicationContext(), HearingLossInfo.class);
            startActivity(intent);
        } else if (view.getId() == R.id.myHearingAid){
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.backBtn) {
            finish();
            Intent intent = new Intent(SurveyResult.this, MenuActivity.class);
            startActivity(intent);
        }
    }
}
