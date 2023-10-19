package com.example.hearoptima_d_01.views.HearingAidInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.TestResultInput.DataInputChoice;

public class HearingAidList extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_aid_search_filter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.filter) {
            Intent intent = new Intent(getApplicationContext(), DataInputChoice.class);
            startActivity(intent);
        }
    }
}