package com.example.hearoptima_d_01.views.HearingAidInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;
import com.example.hearoptima_d_01.views.HearingAidFind.HearingAidFindAddfilter;

public class CoChlearImplantInfo extends AppCompatActivity implements View.OnClickListener {
    Button hearingLossInfoBtn;
    Button hearingAidInfoBtn;
    Button cochlearImplantInfoBtn;
    ImageButton HomeImageBtn;
    ImageButton HearingAidSearchImageBtn;
    ImageButton MyPageImageBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cochlear_implant_info);

        hearingLossInfoBtn = findViewById(R.id.hearingLossInfobtn);
        hearingLossInfoBtn.setOnClickListener(this);

        hearingAidInfoBtn = findViewById(R.id.hearingAidInfobtn);
        hearingAidInfoBtn.setOnClickListener(this);

        cochlearImplantInfoBtn = findViewById(R.id.cochlearImplantInfobtn);
        cochlearImplantInfoBtn.setOnClickListener(this);

        HomeImageBtn = findViewById(R.id.HomeImage);
        HomeImageBtn.setOnClickListener(this);

        HearingAidSearchImageBtn = findViewById(R.id.HearingAidSearchImage);
        HearingAidSearchImageBtn.setOnClickListener(this);

        MyPageImageBtn = findViewById(R.id.MyPageImage);
        MyPageImageBtn.setOnClickListener(this);

    }

    public void onClick(View view){

        if (view.getId() == R.id.hearingLossInfobtn){
            Intent intent = new Intent(getApplicationContext(), HearingLossInfo.class);
            startActivity(intent);
        } else if (view.getId() == R.id.hearingAidInfobtn) {
            Intent intent = new Intent(getApplicationContext(), HearingAidInfo.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HomeImage) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.HearingAidSearchImage) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFindAddfilter.class);
            startActivity(intent);
        }
    }
}