package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;

public class SurveyResult extends AppCompatActivity {

    TextView hearingLossExpectation;
    ImageView hearingLossView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_result);

        int receivedTotalScore = getIntent().getIntExtra("TOTAL_SCORE", 0);

        String resultDescription;
        int imageResource = R.drawable.normal_hearing;  // 초기 이미지 리소스 설정

        if (receivedTotalScore <= 3) {
            resultDescription = "정상";
            imageResource = R.drawable.normal_hearing;
        } else if (receivedTotalScore <= 8) {
            resultDescription = "경도 난청";
            imageResource = R.drawable.mild_hearing_loss;
        } else if (receivedTotalScore <= 12) {
            resultDescription = "중도 난청";
            imageResource = R.drawable.moderate_hearing_loss;
        } else if (receivedTotalScore <= 16) {
            resultDescription = "중고도 난청";
            imageResource = R.drawable.moderately_severe_hearing_loss;
        } else if (receivedTotalScore <= 20) {
            resultDescription = "고도난청";
            imageResource = R.drawable.severe_hearing_loss;
        } else {
            resultDescription = "심도난청";
            imageResource = R.drawable.profound_hearing_loss;
        }

        // 결과 값 표시
        TextView resultExpectation = findViewById(R.id.resultExpectation);
        resultExpectation.setText(resultDescription);  // 예상 진단 추가

        hearingLossExpectation = findViewById(R.id.hearingLossClassification);
        hearingLossExpectation.setText(resultDescription);  // 난청 종류 추가

        hearingLossView = findViewById(R.id.hearingLossView);
        hearingLossView.setImageResource(imageResource);  // 이미지 리소스 설정

        Button returnMenuBtn = findViewById(R.id.returnMenuBtn);
        returnMenuBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SurveyResult.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}
