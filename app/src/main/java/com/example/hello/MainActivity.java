package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //MainActivity가 활성화 될때 최초 한번 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    //버튼을 눌렀을때 호출되는 메소드정의하기 //메소드명은 마음대로 지을수 있다.
    // 반드시 인자로 view type 을 받아야된다.
    public void btnClicked(View v){
        Toast.makeText(this, "버튼을 눌렀네요?", Toast.LENGTH_SHORT).show();
    }
}