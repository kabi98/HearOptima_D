package com.example.hearoptima_d_01.views.TestResultInput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.views.Common.MenuActivity;

public class TestResultInput extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton dataInputBtn;
    ImageButton returnMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_input);

        dataInputBtn = findViewById(R.id.dataInput);
//        dataInputBtn.setOnClickListener(this);
        returnMenuBtn = findViewById(R.id.returnMenu);
        returnMenuBtn.setOnClickListener(this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.returnMenu) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }
    }
}
