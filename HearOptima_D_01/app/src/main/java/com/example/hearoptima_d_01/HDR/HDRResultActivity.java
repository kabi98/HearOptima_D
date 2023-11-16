package com.example.hearoptima_d_01.HDR;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;

import java.util.List;

public class HDRResultActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdr_result);

        resultTextView = findViewById(R.id.resultTextView);

        HDR hdr = new HDR();

        Intent intent = getIntent();
        hdr.setLeftACPTA(intent.getIntExtra("LEFT_ACT_VALUE", 0));
        hdr.setRightACPTA(intent.getIntExtra("RIGHT_ACT_VALUE", 0));
        hdr.setLeftBCPTA(intent.getIntExtra("LEFT_BCT_VALUE", 0));
        hdr.setRightBCPTA(intent.getIntExtra("RIGHT_BCT_VALUE", 0));
        hdr.setLeftWRS(intent.getIntExtra("LEFT_WRS_VALUE", 0));
        hdr.setRightWRS(intent.getIntExtra("RIGHT_WRS_VALUE", 0));

        List<HDR_RANGE> outputList = hdr.calculate();

        StringBuilder resultText = new StringBuilder();
        for(HDR_RANGE out : outputList) {
            resultText.append(out).append(", Help msg: ").append(hdr.getHearingAidsHelpMsg(out)).append("\n");
        }

        resultTextView.setText(resultText.toString());
    }
}