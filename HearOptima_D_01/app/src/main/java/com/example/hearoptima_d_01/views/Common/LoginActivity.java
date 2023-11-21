package com.example.hearoptima_d_01.views.Common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.db.AccountDAO;
import com.example.hearoptima_d_01.db.SQLiteControl;
import com.example.hearoptima_d_01.db.SQLiteHelper;
import com.example.hearoptima_d_01.entity.Utils.Account;
import com.example.hearoptima_d_01.global.GlobalVar;
import com.example.hearoptima_d_01.global.TConst;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    String m_TAG = "LoginActivity";
    Context m_Context;

    AppCompatButton loginBtn;
    AppCompatButton m_AppBtnLogin;
    ImageButton m_AppBtnJoin;
    EditText m_EditLoginId;
    EditText m_EditLoginPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        m_Context = LoginActivity.this;

        m_AppBtnLogin = findViewById(R.id.btnLogin);
        m_AppBtnLogin.setOnClickListener(this);

        m_AppBtnJoin = findViewById(R.id.btnJoin);
        m_AppBtnJoin.setOnClickListener(this);

        m_EditLoginId = findViewById(R.id.EditId);
        m_EditLoginPassword = findViewById(R.id.EditPw);

        if (GlobalVar.g_AccJoin.getAcc_phone_id() != null){
            m_EditLoginId.setText(GlobalVar.g_AccJoin.getAcc_phone_id());
            m_EditLoginPassword.setText(GlobalVar.g_AccJoin.getAcc_pwd());
        } else {
            m_EditLoginId.setText("01012345678");
            m_EditLoginPassword.setText("111111");
        }
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            getInfoAndCheckLogIn();
            GlobalVar.g_AccJoin = new Account();
        }
//        else if (view.getId() == R.id.btnJoin) {
//            Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
//            startActivity(intent);
//        }
    }

    private void getInfoAndCheckLogIn() {
        Log.v(m_TAG, "getInfoAndCheckLogIn");

        GlobalVar.g_AccLogin = new Account();
        String strLoginId = m_EditLoginId.getText().toString().trim();
        String strLoginPassword = m_EditLoginPassword.getText().toString().trim();

        Log.v(m_TAG,
                String.format("LogIn Id %s, Pass %s", strLoginId, strLoginPassword));

        AccountDAO accountDAO = new AccountDAO(m_Context);
        Account accSelect = accountDAO.selectLogin(strLoginId, strLoginPassword);
        accountDAO.releaseAndClose();

        if(accSelect != null){
            Toast toast = Toast.makeText(getApplicationContext(), "로그인 성공 : 메뉴 화면으로 이동합니다.",Toast.LENGTH_SHORT);
            toast.show();
            GlobalVar.g_AccLogin = accSelect;
            Log.v(m_TAG, GlobalVar.g_AccLogin.toString());

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);

        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "로그인 실패 : 아이디와 비밀번호를 확인하세요.",Toast.LENGTH_SHORT);
            toast.show();

        }

    }



/*

    private void getInfoAndCheckLogIn() {
        Log.v(m_TAG, "getInfoAndCheckLogIn");

        GlobalVar.g_AccLogin = new Account();
        String strLoginId = m_EditLoginId.getText().toString().trim();
        String strLoginPaassword = m_EditLoginPassword.getText().toString().trim();

        Log.v(m_TAG, String.format("LogIn %s, Pass %s", strLoginId, strLoginPaassword));

        SQLiteHelper helper = new SQLiteHelper(m_Context, TConst.DB_FILE, null, TConst.DB_VER);
        SQLiteControl sqlcon = new SQLiteControl(helper);

        Account accSelect = sqlcon.test(strLoginId, strLoginPaassword);
        sqlcon.db_close();
        Log.v("strLoginID", ""+accSelect.getAcc_id());

        if(accSelect != null){
            Toast toast = Toast.makeText(getApplicationContext(), "로그인 성공 : 메뉴 화면으로 이동합니다.", Toast.LENGTH_SHORT);
            toast.show();
            GlobalVar.g_AccLogin = accSelect;
            Log.v(m_TAG, GlobalVar.g_AccLogin.toString());

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "로그인 실패 : 아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


 */
}
