package com.example.hearoptima_d_01.HDR;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.TestResultInput.TestResultInput;

import java.util.List;

public class HDRResultActivity extends AppCompatActivity {

    private TextView resultTextView, resultTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input_result);

        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2); // 오른쪽 결과 텍스트 뷰

        TextView resultExpectation = findViewById(R.id.ResultExpectation);
        TextView resultExpectation2 = findViewById(R.id.ResultExpectation2);
        TextView resultExpectationInfo = findViewById(R.id.ResultExpectationInfo);

        HDR hdr = new HDR();

        Intent intent = getIntent();
        int leftACPTA = intent.getIntExtra("LEFT_ACT_VALUE", 0);
        int rightACPTA = intent.getIntExtra("RIGHT_ACT_VALUE", 0);
        hdr.setLeftACPTA(leftACPTA);
        hdr.setRightACPTA(rightACPTA);
        hdr.setLeftBCPTA(intent.getIntExtra("LEFT_BCT_VALUE", 0));
        hdr.setRightBCPTA(intent.getIntExtra("RIGHT_BCT_VALUE", 0));
        hdr.setLeftWRS(intent.getIntExtra("LEFT_WRS_VALUE", 0));
        hdr.setRightWRS(intent.getIntExtra("RIGHT_WRS_VALUE", 0));

        List<HDR_RANGE> outputList = hdr.calculate();

        StringBuilder leftResultText = new StringBuilder();
        for(HDR_RANGE out : outputList) {
            leftResultText.append(out).append("\n");
        }
        leftResultText.append(getClassification(leftACPTA));

        resultTextView.setText(leftResultText.toString());

        StringBuilder rightResultText = new StringBuilder();
        rightResultText.append(getClassification(rightACPTA));

        resultTextView2.setText(rightResultText.toString());

        String leftClassification = getClassification(leftACPTA);
        String rightClassification = getClassification(rightACPTA);

        resultExpectation.setText(leftClassification);
        resultExpectation2.setText(rightClassification);

        String leftHearingLossInfo = getHearingLossInfo(leftACPTA);
        String rightHearingLossInfo = getHearingLossInfo(rightACPTA);

        resultExpectationInfo.setText(leftHearingLossInfo + "\n" + rightHearingLossInfo);
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