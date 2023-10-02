package com.example.hearoptima_d_01.views.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton loginBtn;
    ImageButton joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        joinBtn = findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.loginBtn){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
//        else if (view.getId() == R.id.joinBtn) {
//            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//            startActivity(intent);
//
//        }
    }
}
