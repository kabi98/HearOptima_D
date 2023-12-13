package com.example.hearoptima_d_03.views.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_03.R;

public class MyPageActivity extends AppCompatActivity implements View.OnClickListener{

    AppCompatButton go_menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        go_menuBtn = findViewById(R.id.GoMenu);
        go_menuBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.GoMenu){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
