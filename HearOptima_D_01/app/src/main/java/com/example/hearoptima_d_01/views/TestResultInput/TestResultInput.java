package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.HDR.HDRResultActivity;
import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingAidInfo;

public class TestResultInput extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton dataInputBtn;
    EditText rightACTInput;
    EditText rightBCTInput;
    EditText rightWRSInput;
    EditText leftACTInput;
    EditText leftBCTInput;
    EditText leftWRSInput;
    ImageButton homeImageButton;
    ImageButton HearingAidSearchImageBtn;
    ImageButton hearingAidInfoImageButton;
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input);

        dataInputBtn = findViewById(R.id.dataInput);
        rightACTInput = findViewById(R.id.right_ACT_input);
        rightBCTInput = findViewById(R.id.right_BCT_input);
        rightWRSInput = findViewById(R.id.right_WRS_input);
        leftACTInput = findViewById(R.id.left_ACT_input);
        leftBCTInput = findViewById(R.id.left_BCT_input);
        leftWRSInput = findViewById(R.id.left_WRS_input);
        homeImageButton = findViewById(R.id.HomeImage);

        homeImageButton.setOnClickListener(this);

        hearingAidInfoImageButton = findViewById(R.id.HearingAidInfoImage);
        hearingAidInfoImageButton.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);


        dataInputBtn.setOnClickListener(this);
        Log.d("HDRResultActivity datavalue", "datavalue: ");
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.HomeImage){
            finish();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidInfo.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        } else if (view.getId() == R.id.dataInput) {
            sendData();
        }
        if (view.getId() == R.id.backBtn){
            finish();
        }
    }

    private void sendData() {
        Intent intent = new Intent(TestResultInput.this, HDRResultActivity.class);

        intent.putExtra("RIGHT_ACT_VALUE", parseInputValue(rightACTInput.getText().toString()));
        intent.putExtra("RIGHT_BCT_VALUE", parseInputValue(rightBCTInput.getText().toString()));
        intent.putExtra("RIGHT_WRS_VALUE", parseInputValue(rightWRSInput.getText().toString()));
        intent.putExtra("LEFT_ACT_VALUE", parseInputValue(leftACTInput.getText().toString()));
        intent.putExtra("LEFT_BCT_VALUE", parseInputValue(leftBCTInput.getText().toString()));
        intent.putExtra("LEFT_WRS_VALUE", parseInputValue(leftWRSInput.getText().toString()));

        startActivity(intent);
    }

    private int parseInputValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0; // 입력이 유효하지 않은 경우 0을 반환
        }
    }
}
