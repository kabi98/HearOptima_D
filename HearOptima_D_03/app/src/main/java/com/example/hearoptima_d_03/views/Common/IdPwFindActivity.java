package com.example.hearoptima_d_03.views.Common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_03.R;

public class IdPwFindActivity extends AppCompatActivity implements View.OnClickListener{
    AppCompatButton m_AppBtnGoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        m_AppBtnGoLogin = findViewById(R.id.AppBtnJoinResultGoLogin);
        m_AppBtnGoLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.AppBtnJoinResultGoLogin){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

