package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingLossInfo;

public class SurveyResult extends AppCompatActivity implements View.OnClickListener {

    TextView hearingLossExpectation, resultExpectation, hearingLossInfo, hearingAidList;
    ImageView hearingLossView;
    ImageButton HomeImageBtn;
    ImageButton HearingAidSearchImageBtn;
    ImageButton HearingAidInfoImageBtn;
    ImageButton MyPageImageBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_result);

        int receivedTotalScore = getIntent().getIntExtra("TOTAL_SCORE", 0);

        String resultDescription;
        int imageResource = R.drawable.normal_hearing;  // 초기 이미지 리소스 설정

        if (receivedTotalScore <= 3) {
            resultDescription = "정상(20dB 이하)";
            imageResource = R.drawable.normal_hearing;
        } else if (receivedTotalScore <= 8) {
            resultDescription = "경도 난청(21~30dB)";
            imageResource = R.drawable.mild_hearing_loss;
        } else if (receivedTotalScore <= 12) {
            resultDescription = "중도 난청(41~55dB)";
            imageResource = R.drawable.moderate_hearing_loss;
        } else if (receivedTotalScore <= 16) {
            resultDescription = "중고도 난청(56~70dB)";
            imageResource = R.drawable.moderately_severe_hearing_loss;
        } else if (receivedTotalScore <= 20) {
            resultDescription = "고도난청(71~90dB)";
            imageResource = R.drawable.severe_hearing_loss;
        } else {
            resultDescription = "심도난청(91dB 이상)";
            imageResource = R.drawable.profound_hearing_loss;
        }

        // 결과 값 표시
        TextView resultExpectation = findViewById(R.id.resultExpectation);
        resultExpectation.setText(resultDescription);  // 예상 진단 추가

        hearingLossExpectation = findViewById(R.id.hearingLossClassification);
        hearingLossExpectation.setText(resultDescription);  // 난청 종류 추가

        hearingLossView = findViewById(R.id.hearingLossView);
        hearingLossView.setImageResource(imageResource);  // 이미지 리소스 설정

        hearingLossInfo = findViewById(R.id.hearingLossInfo);
        hearingLossInfo.setText(getHearingLossInfo(receivedTotalScore));

        hearingAidList = findViewById(R.id.hearingAidList);
        hearingAidList.setText(getHearingAidList(receivedTotalScore));

        HomeImageBtn = findViewById(R.id.HomeImage);
        HomeImageBtn.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        HearingAidInfoImageBtn = findViewById(R.id.HearingAidInfoImage);
        HearingAidInfoImageBtn.setOnClickListener(this);

        MyPageImageBtn = findViewById(R.id.MyPageImage);
        MyPageImageBtn.setOnClickListener(this);

        ImageButton returnMenuBtn = findViewById(R.id.backstepBtn);
        returnMenuBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SurveyResult.this, SurveyStart.class);
            startActivity(intent);
        });
    }
    public void onClick(View view){
        if (view.getId() == R.id.HomeImage){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFindAddfilter.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(getApplicationContext(), HearingLossInfo.class);
            startActivity(intent);
        }
    }

    private String getHearingLossInfo(int value) {
        if (value <= 3) {
            return "정상";
        } else if (value <= 8) {
            return "- 1:1 대화에는 거의 지장이 없음\n" +
                    "- 작은 소리, 속삭이는 소리를 잘 듣지 못함\n" +
                    "- 3~5M 떨어진 곳에서 대화하거나 집단으로 대화할 때 보통의 회화 청취가 곤란";
        } else if (value <= 12) {
            return "- 1m 정도 떨어진 곳에서 큰 소리는 알아들을 수 있음\n" +
                    "- 집단으로 대화하는 것은 알아듣기가 곤란\n" +
                    "- 고주파 난청인 경우 마찰음의 발음(ㅅ, ㅊ, ㅆ, ㅉ)을 알아듣기 어려움";
        } else if (value <= 16) {
            return "- 큰 소리만 들을 수 있음\n" +
                    "- 군중 속이나 강의실에서는 언어이해가 곤란";
        } else if (value <= 20) {
            return "- 귀 가까이에서 말하면 들을 수 있음\n" +
                    "- 일상 대화 시 모음 식별은 가능하나 자음 식별이 곤란\n" +
                    "- 매우 큰 소리에만 반응\n" +
                    "- 언어의 이해는 거의 불가능";
        } else {
            return "- 상당히 큰소리에도 반응이 없거나 폭발음 등에만 반응";
        }
    }

    private String getHearingAidList(int value) {
        if (value <= 3) {
            return "정상";
        } else if (value <= 8) {
            return "- 초소형(IIC)\n" +
                    "- 고막형(CIC)\n" +
                    "- 귓속형(ITE)\n" +
                    "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 12) {
            return "- 초소형(IIC)\n" +
                    "- 고막형(CIC)\n" +
                    "- 귓속형(ITE)\n" +
                    "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 16) {
            return "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 20) {
            return "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else {
            return "- 귀걸이형(BTE)";
        }
    }
}
