package com.example.hearoptima_d_02.views._Temp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_02.views.Common.ImageProgress;
import com.example.hearoptima_d_02.R;

public class ProgressBarTestActivity extends AppCompatActivity implements View.OnClickListener{

    Button m_BtnPlus;
    Button m_BtnMinus;
    ImageProgress m_ProgressTest;

    int m_iCur;


    Button pBtn;
    Button mBtn;
    ImageView imgV;
    Context m_context = null;
    int row = 0;
    String[] m_arrPrgsFile = {"progress00","progress01","progress02","progress03","progress04","progress05","progress06"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        m_context = this;

///////////////////////////////////////////////////////////////////////////
        m_BtnMinus = findViewById(R.id.minusBtn);
        m_BtnMinus.setOnClickListener(this);

        m_BtnPlus = findViewById(R.id.plusBtn);
        m_BtnPlus.setOnClickListener(this);

        m_ProgressTest = findViewById(R.id.ImageProgress) ;
        m_iCur = 0;
        m_ProgressTest.setProgress(m_iCur);
///////////////////////////////////////////////////////////////////////////
        pBtn = (Button) findViewById(R.id.pBtn);
        pBtn.setOnClickListener(this);

        mBtn = (Button) findViewById(R.id.mBtn);
        mBtn.setOnClickListener(this);

        imgV = (ImageView) findViewById(R.id.imgV);
///////////////////////////////////////////////////////////////////////////

    }

    @Override
    public void onClick(View view) {
///////////////////////////////////////////////////////////////////////////
        if (view.getId() == R.id.plusBtn) {
            Log.v("ProgressTest onClick", "plusBtn");
            m_iCur++;
            m_ProgressTest.setProgress(m_iCur);
            m_iCur = m_ProgressTest.getProgress();

        } else if (view.getId() == R.id.minusBtn) {
            Log.v("ProgressTest onClick", "minusBtn");
            m_iCur--;
            m_ProgressTest.setProgress(m_iCur);
            m_iCur = m_ProgressTest.getProgress();
///////////////////////////////////////////////////////////////////////////
        } else if (view.getId() == R.id.pBtn) {
            Log.v("ProgressTest onClick", "pBtn");
            row = Integer.parseInt(imgV.getTag().toString());
            Log.v("progress Value", "value" + row);
            if(row<=5){
                int id = m_context.getResources().getIdentifier(m_arrPrgsFile[row+1],"drawable",getPackageName());
                imgV.setImageResource(id);
                imgV.setTag(row+1);
            }
        } else if (view.getId() == R.id.mBtn) {
            Log.v("ProgressTest onClick", "mBtn");
            row = Integer.parseInt(imgV.getTag().toString());
            Log.v("progress Value", "value" + row);
            if(row>0){
                int id = m_context.getResources().getIdentifier(m_arrPrgsFile[row-1],"drawable",getPackageName());
                imgV.setImageResource(id);
                imgV.setTag(row-1);
            }
        }
///////////////////////////////////////////////////////////////////////////

    }
}
