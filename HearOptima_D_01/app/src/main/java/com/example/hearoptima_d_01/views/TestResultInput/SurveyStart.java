package com.example.hearoptima_d_01.views.TestResultInput;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;

public class SurveyStart extends AppCompatActivity {

    TextView pttTestText;

    // 예시: 퀴즈 문제 배열 (추후 변경 가능)
    String[] quizQuestions = {
            "소리가 들릴 때마다 ‘잘 들립니다’ 버튼을,\n안 들리면 ‘안 들립니다’ 버튼을 선택해 주세요.",
            "두 번째 문제 내용",
            "세 번째 문제 내용"
    };

    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_start);

        pttTestText = findViewById(R.id.pttTestText);

        // 예시로, '다음' 버튼을 추가하여 문제를 다음으로 변경
        Button nextButton = new Button(this);  // 임의로 버튼 생성, 레이아웃에 실제로 추가해야 함
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });
    }

    private void nextQuestion() {
        if (currentQuestionIndex < quizQuestions.length - 1) {
            currentQuestionIndex++;
            pttTestText.setText(quizQuestions[currentQuestionIndex]);
        } else {
            // 모든 문제를 마쳤을 경우의 로직 (예: 다른 액티비티로 이동)
        }
    }
}