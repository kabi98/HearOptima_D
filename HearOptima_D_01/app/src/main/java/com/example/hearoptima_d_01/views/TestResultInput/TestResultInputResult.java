package com.example.hearoptima_d_01.views.TestResultInput;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;

public class TestResultInputResult extends AppCompatActivity {
    TextView rightHearingLossExpectation;
    ImageView rightHearingLossView;
    TextView leftHearingLossExpectation;
    ImageView leftHearingLossView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input_result);
    }
}
