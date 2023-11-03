package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;
import com.example.hearoptima_d_01.views.HearingAidInfo.CoChlearImplantInfo;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingAidInfo;
import com.example.hearoptima_d_01.views.HearingAidInfo.HearingLossInfo;

public class TestResultInput extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton dataInputBtn;
    AppCompatButton myHearingAidBtn;
    ImageButton returnMenuBtn;
    EditText rightACTInput;
    EditText rightBCTInput;
    EditText rightWRSInput;
    EditText leftACTInput;
    EditText leftBCTInput;
    EditText leftWRSInput;
    ImageButton HomeImageBtn;
    ImageButton HearingAidSearchImageBtn;
    ImageButton HearingAidInfoImageBtn;
    ImageButton MyPageImageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input);

        dataInputBtn = findViewById(R.id.dataInput);
        dataInputBtn.setOnClickListener(this);

        rightACTInput = findViewById(R.id.right_ACT_input);
        rightBCTInput = findViewById(R.id.right_BCT_input);
        rightWRSInput = findViewById(R.id.right_WRS_input);
        leftACTInput = findViewById(R.id.left_ACT_input);
        leftBCTInput = findViewById(R.id.left_BCT_input);
        leftWRSInput = findViewById(R.id.left_WRS_input);

        HomeImageBtn = findViewById(R.id.HomeImage);
        HomeImageBtn.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        HearingAidInfoImageBtn = findViewById(R.id.HearingAidInfoImage);
        HearingAidInfoImageBtn.setOnClickListener(this);

        MyPageImageBtn = findViewById(R.id.MyPageImage);
        MyPageImageBtn.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.dataInput) {
            Intent intent = new Intent(getApplicationContext(), TestResultInputResult.class);

            int rightACTValueInt = parseInputValue(rightACTInput.getText().toString());
            intent.putExtra("RIGHT_ACT_VALUE", rightACTValueInt);

            int rightBCTValueInt = parseInputValue(rightBCTInput.getText().toString());
            intent.putExtra("RIGHT_BCT_VALUE", rightBCTValueInt);

            int rightWRSValueInt = parseInputValue(rightWRSInput.getText().toString());
            intent.putExtra("RIGHT_WRS_VALUE", rightWRSValueInt);

            int leftACTValueInt = parseInputValue(leftACTInput.getText().toString());
            intent.putExtra("LEFT_ACT_VALUE", leftACTValueInt);

            int leftBCTValueInt = parseInputValue(leftBCTInput.getText().toString());
            intent.putExtra("LEFT_BCT_VALUE", leftBCTValueInt);

            int leftWRSValueInt = parseInputValue(leftWRSInput.getText().toString());
            intent.putExtra("LEFT_WRS_VALUE", leftWRSValueInt);

            startActivity(intent);
        }
        if (view.getId() == R.id.HomeImage){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFindAddfilter.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(getApplicationContext(), HearingLossInfo.class);
            startActivity(intent);

        }
    }

    private int parseInputValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 500; // return default value
        }
    }

    // Save methods
    public void saveRightACTInputValue() {
        String inputValue = rightACTInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    public void saveRightBCTInputValue() {
        String inputValue = rightBCTInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    public void saveRightWRSInputValue() {
        String inputValue = rightWRSInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    public void saveLeftACTInputValue() {
        String inputValue = leftACTInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    public void saveLeftBCTInputValue() {
        String inputValue = leftBCTInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    public void saveLeftWRSInputValue() {
        String inputValue = leftWRSInput.getText().toString().trim();
        // TODO: Store inputValue somewhere as needed
    }

    // Get methods
    public String getRightACTInputValue() {
        return rightACTInput.getText().toString().trim();
    }

    public String getRightBCTInputValue() {
        return rightBCTInput.getText().toString().trim();
    }

    public String getRightWRSInputValue() {
        return rightWRSInput.getText().toString().trim();
    }

    public String getLeftACTInputValue() {
        return leftACTInput.getText().toString().trim();
    }

    public String getLeftBCTInputValue() {
        return leftBCTInput.getText().toString().trim();
    }

    public String getLeftWRSInputValue() {
        return leftWRSInput.getText().toString().trim();
    }
}
