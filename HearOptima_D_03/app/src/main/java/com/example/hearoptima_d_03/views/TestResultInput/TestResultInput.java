package com.example.hearoptima_d_03.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_03.HDR.HDRResultActivity;
import com.example.hearoptima_d_03.R;
import com.example.hearoptima_d_03.entity.DataInputDAO;
import com.example.hearoptima_d_03.entity.HrDataInfoUnit;
import com.example.hearoptima_d_03.views.Common.MenuActivity;
import com.example.hearoptima_d_03.views.Common.MyPageActivity;
import com.example.hearoptima_d_03.views.HearingAidFind.HearingAidFind;
import com.example.hearoptima_d_03.views.HearingAidInfo.HearingAidInfo;

public class TestResultInput extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton dataInputBtn;
    EditText rightACTInput;
    EditText rightBCTInput;
    EditText rightWRSInput;
    EditText leftACTInput;
    EditText leftBCTInput;
    EditText leftWRSInput;
    DataInputDAO dataInputDAO;
    ImageButton homeImageButton, HearingAidSearchImageBtn, hearingAidInfoImageButton, backBtn, myPageBtn;

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

//        rightACTInput.setText("95");
//        rightBCTInput.setText("95");
//        rightWRSInput.setText("90");
//        leftACTInput.setText("95");
//        leftBCTInput.setText("95");
//        leftWRSInput.setText("90");

        homeImageButton.setOnClickListener(this);

        hearingAidInfoImageButton = findViewById(R.id.HearingAidInfoImage);
        hearingAidInfoImageButton.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);

        myPageBtn = findViewById(R.id.MyPageImage);
        myPageBtn.setOnClickListener(this);

        dataInputBtn.setOnClickListener(this);
        Log.d("HDRResultActivity datavalue", "datavalue: ");

        dataInputDAO = new DataInputDAO(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.HomeImage){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
//            finish();
        } else if (view.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidInfo.class);
            startActivity(intent);
//            finish();
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
//            finish();
        } else if (view.getId() == R.id.dataInput) {
            saveDataInput();
            sendData();
//            finish();
        } else if (view.getId() == R.id.MyPageImage) {
            Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
            startActivity(intent);
//            finish();
        }
        if (view.getId() == R.id.backBtn){
//            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//            startActivity(intent);
            finish();
        }
    }

    private void saveDataInput(){

        try{
            int rightACT = parseInputValue(rightACTInput.getText().toString());
            int rightBCT = parseInputValue(rightBCTInput.getText().toString());
            int rightWRS = parseInputValue(rightWRSInput.getText().toString());
            int leftACT = parseInputValue(leftACTInput.getText().toString());
            int leftBCT = parseInputValue(leftBCTInput.getText().toString());
            int leftWRS = parseInputValue(leftWRSInput.getText().toString());

            // HrDataInfoUnit 객체 생성
            HrDataInfoUnit dataInfoUnit = new HrDataInfoUnit(0, 0, rightACT, rightBCT, rightWRS, leftACT, leftBCT, leftWRS);
            DataInputDAO dataInputDAO = new DataInputDAO(this);
            // 데이터베이스에 저장
            dataInputDAO.insertDataInfoUnit(dataInfoUnit);
            dataInputDAO.releaseAndClose();

            Log.v("TestResultInput123", "Data saved to database successfully");
            Log.v("TestResultInput123", "Input Values - Right ACT: " + rightACT + ", Right BCT: " + rightBCT + ", Right WRS: " + rightWRS
                    + ", Left ACT: " + leftACT + ", Left BCT: " + leftBCT + ", Left WRS: " + leftWRS);
        } catch (Exception e) {
            Log.e("TestResultInput123", "Error saving data to database", e);
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
