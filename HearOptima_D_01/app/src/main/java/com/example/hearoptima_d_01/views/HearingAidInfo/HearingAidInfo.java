package com.example.hearoptima_d_01.views.HearingAidInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;

public class HearingAidInfo extends AppCompatActivity implements View.OnClickListener {

    Button hearingLossInfoBtn2, hearingLossInfoBtn1;
    Button hearingAidInfoBtn2, hearingAidInfoBtn;
    Button cochlearImplantInfoBtn1, cochlearImplantInfoBtn;
    ImageButton HomeImageBtn;
    ImageButton HearingAidSearchImageBtn;
    ImageButton MyPageImageBtn;
    private ScrollView hearingLossInfo, hearingAidInfo, cochlearImplantInfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_aid_form_info);

        hearingLossInfoBtn2 = findViewById(R.id.hearingLossInfobtn2);
        hearingLossInfoBtn2.setOnClickListener(this);

        hearingLossInfoBtn1 = findViewById(R.id.hearingLossInfobtn1);
        hearingLossInfoBtn1.setOnClickListener(this);

        hearingAidInfoBtn2 = findViewById(R.id.hearingAidInfobtn2);
        hearingAidInfoBtn2.setOnClickListener(this);

        hearingAidInfoBtn = findViewById(R.id.hearingAidInfobtn);
        hearingAidInfoBtn.setOnClickListener(this);

        cochlearImplantInfoBtn1 = findViewById(R.id.cochlearImplantInfobtn1);
        cochlearImplantInfoBtn1.setOnClickListener(this);

        cochlearImplantInfoBtn = findViewById(R.id.cochlearImplantInfobtn);
        cochlearImplantInfoBtn.setOnClickListener(this);

        HomeImageBtn = findViewById(R.id.HomeImage);
        HomeImageBtn.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        MyPageImageBtn = findViewById(R.id.MyPageImage);
        MyPageImageBtn.setOnClickListener(this);

        hearingLossInfo = findViewById(R.id.hearingLossInfo);
        hearingAidInfo = findViewById(R.id.hearingaidinfo);
        cochlearImplantInfo = findViewById(R.id.cochlearimplantinfo);

    }

    public void onClick(View view){

        if (view.getId() == R.id.HomeImage) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFindAddfilter.class);
            startActivity(intent);
        } else if (view.getId() == R.id.hearingLossInfobtn2 || view.getId() == R.id.hearingLossInfobtn1) {
            showHearingLossInfo();
        } else if (view.getId() == R.id.hearingAidInfobtn2 || view.getId() == R.id.hearingAidInfobtn) {
            showHearingAidInfo();
        } else if (view.getId() == R.id.cochlearImplantInfobtn1 || view.getId() == R.id.cochlearImplantInfobtn) {
            showCochlearImplantInfo();
        }
    }
    // 청각 손실 정보를 보여주는 메소드
    private void showHearingLossInfo() {
        hearingLossInfo.setVisibility(View.VISIBLE);
        hearingAidInfo.setVisibility(View.GONE);
        cochlearImplantInfo.setVisibility(View.GONE);
    }

    // 청력 보조 장치 정보를 보여주는 메소드
    private void showHearingAidInfo() {
        hearingLossInfo.setVisibility(View.GONE);
        hearingAidInfo.setVisibility(View.VISIBLE);
        cochlearImplantInfo.setVisibility(View.GONE);
    }

    // 인공와우 정보를 보여주는 메소드
    private void showCochlearImplantInfo() {
        hearingLossInfo.setVisibility(View.GONE);
        hearingAidInfo.setVisibility(View.GONE);
        cochlearImplantInfo.setVisibility(View.VISIBLE);
    }
}