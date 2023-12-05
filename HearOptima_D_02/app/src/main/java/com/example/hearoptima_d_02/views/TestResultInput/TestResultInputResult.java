package com.example.hearoptima_d_02.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_02.R;
import com.example.hearoptima_d_02.views.Common.MenuActivity;

public class TestResultInputResult extends AppCompatActivity {
    TextView rightResultExpectation, rightResultExpectation2, rightHearingLossClassification, rightHearingLossInfo, rightHearingAidList;
    TextView leftResultExpectation, leftResultExpectation2, leftHearingLossClassification, leftHearingLossInfo, leftHearingAidList;
    ImageView rightHearingLossView;
    ImageView leftHearingLossView;
    Button returnMenuBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input_result);

        // Initialize Views
//        rightResultExpectation = findViewById(R.id.rightResultExpectation);
//        rightResultExpectation2 = findViewById(R.id.rightResultExpectation2);
//        rightHearingLossClassification = findViewById(R.id.rightHearingLossClassification);
//        rightHearingLossInfo = findViewById(R.id.rightHearingLossInfo);
//        rightHearingAidList = findViewById(R.id.rightHearingAidList);
//        rightHearingLossView = findViewById(R.id.rightHearingLossView);
//
//        leftResultExpectation = findViewById(R.id.leftResultExpectation);
//        leftResultExpectation2 = findViewById(R.id.leftResultExpectation2);
//        leftHearingLossClassification = findViewById(R.id.leftHearingLossClassification);
//        leftHearingLossInfo = findViewById(R.id.leftHearingLossInfo);
//        leftHearingAidList = findViewById(R.id.leftHearingAidList);
//        leftHearingLossView = findViewById(R.id.leftHearingLossView);
//
//        returnMenuBtn = findViewById(R.id.returnMenuBtn);

        // Get data passed from previous activity
        int rightValue = getIntent().getIntExtra("RIGHT_ACT_VALUE", 0);
        int leftValue = getIntent().getIntExtra("LEFT_ACT_VALUE", 0);

        // Set classification text based on the value
        rightResultExpectation.setText(getClassification(rightValue));
        leftResultExpectation.setText(getClassification(leftValue));
        rightHearingLossClassification.setText(getClassification(rightValue));
        leftHearingLossClassification.setText(getClassification(leftValue));
        rightResultExpectation2.setText(getClassification2(rightValue));
        leftResultExpectation2.setText(getClassification2(leftValue));
        rightHearingLossInfo.setText(getHearingLossInfo(rightValue));
        leftHearingLossInfo.setText(getHearingLossInfo(leftValue));
        rightHearingAidList.setText(getHearingAidList(rightValue));
        leftHearingAidList.setText(getHearingAidList(leftValue));
        setImageForHearingLoss(rightHearingLossView, rightValue);
        setImageForHearingLoss(leftHearingLossView, leftValue);

        // TODO: Set the expectation text
        // rightResultExpectation.setText( ... );
        // leftResultExpectation.setText( ... );

        returnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuActivity로 이동
                Intent intent = new Intent(TestResultInputResult.this, MenuActivity.class);
                startActivity(intent);
                finish();  // 필요하다면 현재 액티비티를 종료
            }
        });
    }

    private String getClassification(int value) {
        if (value <= 20) {
            return "정상";
        } else if (value <= 40) {
            return "경도 난청";
        } else if (value <= 55) {
            return "중도 난청";
        } else if (value <= 70) {
            return "중고도 난청";
        } else if (value <= 90) {
            return "고도 난청";
        } else if (value <= 200){
            return "심도 난청";
        } else {
            return "데이터 미입력";
        }
    }
    private String getClassification2(int value) {
        if (value <= 200) {
            return "으로 예상됩니다.";
        } else {
            return " ";
        }
    }

    private String getHearingLossInfo(int value) {
        if (value <= 20) {
            return "정상";
        } else if (value <= 40) {
            return "- 1:1 대화에는 거의 지장이 없음\n" +
                    "- 작은 소리, 속삭이는 소리를 잘 듣지 못함\n" +
                    "- 3~5M 떨어진 곳에서 대화하거나 집단으로 대화할 때 보통의 회화 청취가 곤란";
        } else if (value <= 55) {
            return "- 1m 정도 떨어진 곳에서 큰 소리는 알아들을 수 있음\n" +
                    "- 집단으로 대화하는 것은 알아듣기가 곤란\n" +
                    "- 고주파 난청인 경우 마찰음의 발음(ㅅ, ㅊ, ㅆ, ㅉ)을 알아듣기 어려움";
        } else if (value <= 70) {
            return "- 큰 소리만 들을 수 있음\n" +
                    "- 군중 속이나 강의실에서는 언어이해가 곤란";
        } else if (value <= 90) {
            return "- 귀 가까이에서 말하면 들을 수 있음\n" +
                    "- 일상 대화 시 모음 식별은 가능하나 자음 식별이 곤란\n" +
                    "- 매우 큰 소리에만 반응\n" +
                    "- 언어의 이해는 거의 불가능";
        } else if (value <= 200){
            return "- 상당히 큰소리에도 반응이 없거나 폭발음 등에만 반응";
        } else {
            return "데이터 미입력";
        }
    }

    private String getHearingAidList(int value) {
        if (value <= 20) {
            return "정상";
        } else if (value <= 40) {
            return "- 초소형(IIC)\n" +
                    "- 고막형(CIC)\n" +
                    "- 귓속형(ITE)\n" +
                    "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 55) {
            return "- 초소형(IIC)\n" +
                    "- 고막형(CIC)\n" +
                    "- 귓속형(ITE)\n" +
                    "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 70) {
            return "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 90) {
            return "- 외이도형(ITC)\n" +
                    "- 귀걸이형(BTE)";
        } else if (value <= 200){
            return "- 귀걸이형(BTE)";
        } else {
            return "데이터 미입력";
        }
    }
    private void setImageForHearingLoss(ImageView hearingLossView, int value) {
        if (value <= 20) {
            hearingLossView.setImageResource(R.drawable.normal_hearing);
        } else if (value <= 40) {
            hearingLossView.setImageResource(R.drawable.mild_hearing_loss);
        } else if (value <= 55) {
            hearingLossView.setImageResource(R.drawable.moderate_hearing_loss);
        } else if (value <= 70) {
            hearingLossView.setImageResource(R.drawable.moderately_severe_hearing_loss);
        } else if (value <= 90) {
            hearingLossView.setImageResource(R.drawable.severe_hearing_loss);
        } else if (value <= 200) {
            hearingLossView.setImageResource(R.drawable.profound_hearing_loss);
        } else {
            hearingLossView.setImageResource(0); // 기본 이미지 또는 에러 이미지 설정
        }
    }
}