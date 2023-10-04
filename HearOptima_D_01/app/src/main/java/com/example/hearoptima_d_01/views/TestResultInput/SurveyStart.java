package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;

public class SurveyStart extends AppCompatActivity {

    TextView pttTestText;
    ProgressBar progress_bar;
    int totalScore = 0;

    // 제공된 문제 리스트
    String[] quizQuestions = {
            "어느 상황이든 1:1 대화에 지장이 있습니다.",
            "3-5m 떨어진 곳에서 대화하거나 집단으로 대화할 때 보통의 회화 청취가 곤란합니다.",
            "1m 정도 떨어진 곳에서의 큰 소리는 알아들을 수 없습니다.",
            "군중 속이나 강의실에서는 언어 이해가 곤란합니다.",
            "귀 가까이에서 말하지 않으면 알아들을 수 없습니다.",
            "매우 큰 소리에만 반응하며, 언어의 이해는 거의 불가능합니다.",
            "폭발음 등만 들을 수 있고 상당히 큰 소리도 들을 수 없습니다."
    };

    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_start);

        pttTestText = findViewById(R.id.pttTestText);
        updateQuestion();

        Button alwaysBtn = findViewById(R.id.alwaysBtn);
        alwaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(5);
                nextQuestion();
            }
        });

        Button oftenBtn = findViewById(R.id.oftenBtn);
        oftenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(4);
                nextQuestion();
            }
        });

        Button sometimesBtn = findViewById(R.id.sometimesBtn);
        sometimesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(3);
                nextQuestion();
            }
        });

        Button almostNoneBtn = findViewById(R.id.almostNoneBtn);
        almostNoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(2);
                nextQuestion();
            }
        });

        Button notAtAllBtn = findViewById(R.id.notAtAllBtn);
        notAtAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(1);
                nextQuestion();
            }
        });
        //----------------------------------PROGRESS BAR SETTING----------------------------------//
        progress_bar = findViewById(R.id.progress_bar);
        progress_bar.setIndeterminate(false);
        progress_bar.setProgress(0);
    }

    private void updateQuestion() {
        if (currentQuestionIndex < quizQuestions.length) {
            pttTestText.setText(quizQuestions[currentQuestionIndex]);
        } else {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        }
    }

    private void addScore(int score) {
        totalScore += score;
    }

    private void nextQuestion() {
        if (currentQuestionIndex < quizQuestions.length - 1) {
            currentQuestionIndex++;
            updateQuestion();
        } else {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        }
    }
}