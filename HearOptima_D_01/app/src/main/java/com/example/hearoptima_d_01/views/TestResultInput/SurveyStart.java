package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;

public class SurveyStart extends AppCompatActivity {

    TextView pttTestText;
    ProgressBar progress_bar;
    int totalScore = 0;
    Button returnMenuBtn;

    // 제공된 문제 리스트
    String[] quizQuestions = {
            "Q. 1 \n어느 상황이든 1:1 대화에 지장이 있습니다.",
            "Q. 2 \n3-5m 떨어진 곳에서 대화하거나 집단으로 대화할 때 보통의 회화 청취가 곤란합니다.",
            "Q. 3 \n1m 정도 떨어진 곳에서의 큰 소리는 알아들을 수 없습니다.",
            "Q. 4 \n군중 속이나 강의실에서는 언어 이해가 곤란합니다.",
            "Q. 5 \n귀 가까이에서 말하지 않으면 알아들을 수 없습니다.",
            "Q. 6 \n매우 큰 소리에만 반응하며, 언어의 이해는 거의 불가능합니다.",
            "Q. 7 \n폭발음 등만 들을 수 있고 상당히 큰 소리도 들을 수 없습니다."
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
        returnMenuBtn = findViewById(R.id.returnMenuBtn);
        returnMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuActivity로 이동
                Intent intent = new Intent(SurveyStart.this, MenuActivity.class);
                startActivity(intent);
                finish();  // 필요하다면 현재 액티비티를 종료
            }
        });
    }

    private void initializeButtons() {
        findViewById(R.id.alwaysBtn).setOnClickListener(view -> handleButtonClick(4));
        findViewById(R.id.oftenBtn).setOnClickListener(view -> handleButtonClick(3));
        findViewById(R.id.sometimesBtn).setOnClickListener(view -> handleButtonClick(2));
        findViewById(R.id.almostNoneBtn).setOnClickListener(view -> handleButtonClick(1));
        findViewById(R.id.notAtAllBtn).setOnClickListener(view -> handleButtonClick(0));
    }

    private void handleButtonClick(int score) {
        addScore(score);
        nextQuestion();
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

    private void nextQuestion() {
        currentQuestionIndex++;
        updateQuestion();
    }

    private void goToResultPage() {
        Intent intent = new Intent(getApplicationContext(), SurveyResult.class);
        intent.putExtra("TOTAL_SCORE", totalScore);
        startActivity(intent);
    }
}