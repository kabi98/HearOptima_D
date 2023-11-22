package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;

public class SurveyStart extends AppCompatActivity {

    TextView pttTestText;
    ProgressBar progress_bar;
    int totalScore = 0;
    Button returnMenuBtn;

    // 제공된 문제 리스트
    String[] quizQuestions = {
            "어느 상황이든\n1:1 대화에 지장이 있습니다.",
            "3-5m 떨어진 곳에서 대화하거나\n집단으로 대화할 때,\n보통의 회화 청취가 곤란합니다.",
            "1m 정도 떨어진 곳에서의\n큰 소리는 알아들을 수 없습니다.",
            "군중 속이나 강의실에서는\n언어 이해가 곤란합니다.",
            "귀 가까이에서 말하지 않으면\n알아들을 수 없습니다.",
            "매우 큰 소리에만 반응하며,\n언어의 이해는 거의 불가능합니다.",
            "폭발음 등만 들을 수 있고\n상당히 큰 소리도 들을 수 없습니다."
    };

    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_start);

        pttTestText = findViewById(R.id.pttTestText);
        progress_bar = findViewById(R.id.progress_bar);
        progress_bar.setIndeterminate(false);
        progress_bar.setProgress(0);

        initializeButtons();
        updateQuestion();
//        returnMenuBtn = findViewById(R.id.returnMenuBtn);
//        returnMenuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // MenuActivity로 이동
//                Intent intent = new Intent(SurveyStart.this, MenuActivity.class);
//                startActivity(intent);
//                finish();  // 필요하다면 현재 액티비티를 종료
//            }
//        });
    }

    private void initializeButtons() {
        findViewById(R.id.yesBtn).setOnClickListener(view -> handleYesButtonClick());
        findViewById(R.id.noBtn).setOnClickListener(view -> handleNoButtonClick());
    }

    private void handleYesButtonClick() {
        // "예" 버튼을 눌렀을 때의 로직
        currentQuestionIndex++;

        // 마지막 질문이면 결과 페이지로 바로 이동
        if (currentQuestionIndex >= quizQuestions.length) {
            finishSurvey();
        } else {
            // 아니면 다음 질문을 표시
            updateQuestion();
        }
    }

    private void handleNoButtonClick() {
        // "아니오" 버튼을 눌렀을 때의 로직
        finishSurvey();
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        updateQuestion();
    }

    private void finishSurvey() {
        String resultMessage = "";
        if (currentQuestionIndex <= 1) {
            resultMessage = "일상생활에 큰 지장이 없을 것으로 보입니다.";
        } else if (currentQuestionIndex <= 4) {
            resultMessage = "일상생활에 약간의 지장이 있을 수 있습니다.";
        } else {
            resultMessage = "일상생활에 큰 어려움이 있을 수 있습니다.";
        }

        // 결과 메시지를 전달하여 결과 페이지로 이동
        Intent intent = new Intent(getApplicationContext(), SurveyResult.class);
        intent.putExtra("RESULT_MESSAGE", resultMessage);
        startActivity(intent);
        finish();
    }

    private void updateQuestion() {
        if (currentQuestionIndex < quizQuestions.length) {
            pttTestText.setText(quizQuestions[currentQuestionIndex]);
            progress_bar.setProgress((currentQuestionIndex + 1) * 100 / quizQuestions.length);
        } else {
            goToResultPage();
        }
    }

    private void addScore(int score) {
        totalScore += score;
    }

    private void goToResultPage() {
        Intent intent = new Intent(getApplicationContext(), SurveyResult.class);
        intent.putExtra("TOTAL_SCORE", totalScore);
        startActivity(intent);
    }
}