//package com.example.hearoptima_d_01.views.HearingAidFind;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.example.hearoptima_d_01.R;
//
//public class HearingAidFindFilter extends Activity {
//    private Button applyFilterButton;
//    private Button resetFilterButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_filter);
//
//        initView();
//
//        applyFilterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                applyFilter();
//            }
//        });
//
//        resetFilterButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                resetFilter();
//            }
//        });
//    }
//
//    private void initView(){
//        applyFilterButton = findViewById(R.id.nextStep);
//        resetFilterButton = findViewById(R.id.filterreset);
//    }
//
//    private void applyFilter(){
//        Toast.makeText(this, "필터가 적용되었습니다.", Toast.LENGTH_SHORT).show();
//    }
//
//    private void resetFilter(){
//        Toast.makeText(this, "필터가 초기화 되었습니다.", Toast.LENGTH_SHORT).show();
//    }
//}
