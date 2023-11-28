package com.example.hearoptima_d_01.HDR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.TestResultInput.TestResultInput;

import java.util.List;

public class HDRResultActivity extends AppCompatActivity {

    private TextView rightresultTextView, leftresultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input_result);

        rightresultTextView = findViewById(R.id.rightresultTextView);
        leftresultTextView = findViewById(R.id.leftresultTextView); // 오른쪽 결과 텍스트 뷰
        AppCompatButton dataInputButton = findViewById(R.id.dataInput);

        TextView resultExpectation = findViewById(R.id.ResultExpectation);
        TextView resultExpectation2 = findViewById(R.id.ResultExpectation2);
        TextView resultExpectationInfo = findViewById(R.id.ResultExpectationInfo);

        HDR hdr = new HDR();

        Intent intent = getIntent();
        int leftACPTA = intent.getIntExtra("LEFT_ACT_VALUE", 0);
        int rightACPTA = intent.getIntExtra("RIGHT_ACT_VALUE", 0);
        int leftBCPTA = intent.getIntExtra("LEFT_BCT_VALUE", 0);
        int rightBCPTA = intent.getIntExtra("RIGHT_BCT_VALUE", 0);
        int leftWRS = intent.getIntExtra("LEFT_WRS_VALUE",0);
        int rightWRS = intent.getIntExtra("RIGHT_WRS_VALUE",0);

        hdr.setLeftACPTA(leftACPTA);
        hdr.setRightACPTA(rightACPTA);
        hdr.setLeftBCPTA(leftBCPTA);
        hdr.setRightBCPTA(rightBCPTA);
        hdr.setLeftWRS(leftWRS);
        hdr.setRightWRS(rightWRS);

        List<HDR_RANGE> outputList = hdr.calculate();
        StringBuilder outputText = new StringBuilder();
        StringBuilder leftResultText = new StringBuilder();
        StringBuilder rightResultText = new StringBuilder();

        for (HDR_RANGE out : outputList) {
            outputText.append(out.toString()).append("\n");
            String outputString = out.toString();
            boolean isCochlearImplantation = outputString.equals("CochlearImplantation");
            boolean isCochlearImplantationSingle = outputString.equals("CochlearImplantation_Single");

            if (outputString.equals("한쪽 인공와우")) {
                if (leftACPTA > rightACPTA && leftWRS < rightWRS) {
                    leftResultText.append(outputString).append("\n");
                } else if (rightACPTA > leftACPTA && rightWRS < leftWRS) {
                    rightResultText.append(outputString).append("\n");
                }
            } else if (outputString.equals("인공와우")) {
                leftResultText.append(outputString).append("\n");
                rightResultText.append(outputString).append("\n");
            } else if (outputString.equals("크로스 보청기") || outputString.equals("바이크로스 보청기")) {
                if (leftACPTA > rightACPTA) {
                    leftResultText.append(outputString).append("\n");
                } else {
                    rightResultText.append(outputString).append("\n");
                }
            } else {
                if (outputString.contains("오른쪽")) {
                    rightResultText.append(outputString).append("\n");
                } else if (outputString.contains("왼쪽")) {
                    leftResultText.append(outputString).append("\n");
                }
            }
        }

//        for (HDR_RANGE out : outputList) {
//            String outputString = out.toString();
//            if (outputString.contains("오른쪽")) {
//                rightResultText.append(outputString).append("\n");
//            } else if (outputString.contains("왼쪽")) {
//                leftResultText.append(outputString).append("\n");
//            }
//        }
//        leftResultText.append(getClassification(leftACPTA));
        leftresultTextView.setText(rightResultText.toString());
//        rightResultText.append(getClassification(rightACPTA));
        rightresultTextView.setText(leftResultText.toString());

        String leftClassification = getClassification(leftACPTA);
        String rightClassification = getClassification(rightACPTA);

        if (leftACPTA > rightACPTA) {
            // leftACPTA가 rightACPTA보다 클 경우
            resultExpectation.setText(leftClassification);
            resultExpectation2.setText(leftClassification);
        } else if (rightACPTA > leftACPTA) {
            // rightACPTA가 leftACPTA보다 클 경우
            resultExpectation.setText(rightClassification);
            resultExpectation2.setText(rightClassification);
        } else {
            resultExpectation.setText(rightClassification);
            resultExpectation2.setText(rightClassification);
        }

        String leftHearingLossInfo = getHearingLossInfo(leftACPTA);
        String rightHearingLossInfo = getHearingLossInfo(rightACPTA);

        if (leftACPTA > rightACPTA) {
            // leftACPTA가 rightACPTA보다 높은 경우
            resultExpectationInfo.setText(leftHearingLossInfo);
        } else if (rightACPTA > leftACPTA) {
            // rightACPTA가 leftACPTA보다 높은 경우
            resultExpectationInfo.setText(rightHearingLossInfo);
        } else {
            resultExpectationInfo.setText(rightHearingLossInfo);
        }
        dataInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // HearingAidFind 클래스로 이동하는 Intent 생성
                Intent intent = new Intent(HDRResultActivity.this, HearingAidFind.class);
                startActivity(intent); // 액티비티 시작
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

    private String getHearingLossInfo(int value) {
        if (value <= 20) {
            return "정상입니다";
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
//    private void setImageForHearingLoss(ImageView hearingLossView, int value) {
//        if (value <= 20) {
//            hearingLossView.setImageResource(R.drawable.normal_hearing);
//        } else if (value <= 40) {
//            hearingLossView.setImageResource(R.drawable.mild_hearing_loss);
//        } else if (value <= 55) {
//            hearingLossView.setImageResource(R.drawable.moderate_hearing_loss);
//        } else if (value <= 70) {
//            hearingLossView.setImageResource(R.drawable.moderately_severe_hearing_loss);
//        } else if (value <= 90) {
//            hearingLossView.setImageResource(R.drawable.severe_hearing_loss);
//        } else if (value <= 200) {
//            hearingLossView.setImageResource(R.drawable.profound_hearing_loss);
//        } else {
//            hearingLossView.setImageResource(0); // 기본 이미지 또는 에러 이미지 설정
//        }
//    }
}